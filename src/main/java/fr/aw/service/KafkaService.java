package fr.aw.service;

import fr.aw.model.kafka.gradients.GradientData;
import fr.aw.model.kafka.gradients.Gradients;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Properties;

/**
 * Created by julian on 01/04/18.
 */
@Service
public class KafkaService {

    @Value("${KAFKA_HOST:kafka}")
    private String host;

    @Value("${KAFKA_PORT:29092}")
    private String port;

    @Value("${KAFKA_TARGET_TOPIC:small_topic}")
    private String topic;

    public void send(GradientData data) {
        String servers = new StringBuilder()
                        .append(host)
                        .append(":")
                        .append(port)
                        .toString();

        Properties props = new Properties();
        props.put("bootstrap.servers", servers);
        props.put("client.id", "GradientsProducer");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
        try {
            for (final Gradients gradients : data.getGradients()) {
                for (final String style : gradients.getStyles()) {

                    final String color = gradients.getColor();
                    final ProducerRecord<String, String> r = new ProducerRecord<>(topic, color, style);

                    producer.send(r);
                }
            }
        } finally {
            producer.close();
        }
    }
}
