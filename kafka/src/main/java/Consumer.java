import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.streams.StreamsConfig;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

/**
 * inzheneher created on 24/12/2020 inside the package - PACKAGE_NAME
 */
public class Consumer {
    private final KafkaConsumer<String, String> consumer;

    public Consumer() {
        Properties props = new Properties();
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put("group.id", "1");
        props.put("enable.auto.commit", "true");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Collections.singletonList("output-topic"));
    }

    public void getMessagesFromTopicAndSendToFile() {
        try (BufferedWriter bw =
                     new BufferedWriter(
                             new FileWriter("/home/inzheneher/WORK/TEST/testForEverythingModules/kafka/src/main/resources/output.dat"))) {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100L));
                for (ConsumerRecord<String, String> record : records) {
                    final String result = String.format("key=%s, value=%s, topic=%s, partition=%s, offset=%s",
                            record.key(), record.value(), record.topic(), record.partition(), record.offset());
                    bw.write(result + "\n");
                }
                consumer.commitSync();
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
