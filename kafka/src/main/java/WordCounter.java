import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Named;
import org.apache.kafka.streams.kstream.Produced;

import java.util.Arrays;
import java.util.Properties;

/**
 * inzheneher created on 28/12/2020 inside the package - PACKAGE_NAME
 */
public class WordCounter {
    private final StreamsBuilder builder;
    private final KStream<String, String> wordCountInput;
    private final Properties config;

    public WordCounter() {
        config = new Properties();
        config.put(StreamsConfig.APPLICATION_ID_CONFIG, "wordcount-application");
        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        builder = new StreamsBuilder();
        //1 - stream from Kafka
        wordCountInput = builder.stream("streams-plaintext-input");
    }

    public void countWordsFromStream() {
        //2 - map values to lowercase
        KTable<String, Long> wordCounts = wordCountInput
                .mapValues(textLine -> textLine.toLowerCase())
                //3 - flatmap values split by space
                .flatMapValues(lowerCasedTextLine -> Arrays.asList(lowerCasedTextLine.split(" ")))
                //4 - select key to apply a key (discard old key)
                .selectKey((ignoredKey, word) -> word)
                //5 - group by key before aggregation
                .groupByKey()
                //6 - count occurrences
                .count(Named.as("Counts"));
        //7 - to in order to write the result back to Kafka
        wordCounts.toStream().to("streams-wordcount-output", Produced.with(Serdes.String(), Serdes.Long()));
        KafkaStreams streams = new KafkaStreams(builder.build(), config);
        streams.start();
    }
}
