import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.streams.StreamsConfig;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * inzheneher created on 24/12/2020 inside the package - PACKAGE_NAME
 */
public class Producer {
    private final org.apache.kafka.clients.producer.Producer<String, String> producer;

    public Producer() {
        final Properties props;
        props = new Properties();
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("enable.auto.commit", "true");
        producer = new KafkaProducer<>(props);
    }

    public void getMessagesFromFileAndSendToTopic() {
        try {
            final BufferedReader br = new BufferedReader(
                    new FileReader(
                            "/home/inzheneher/WORK/TEST/testForEverythingModules/kafka/src/main/resources/sample-transaction-log.txt"
                    ));
            String line = br.readLine();
            while (line != null) {
                final String[] record = line.split(":");
                final String key = record[0];
                final String value = record[1];
                producer.send(new ProducerRecord<>("output-topic", key, value));
                if (key.equals("apples")) {
                    producer.send(new ProducerRecord<>("input-topic", key, value));
                }
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        producer.close();
    }
}
