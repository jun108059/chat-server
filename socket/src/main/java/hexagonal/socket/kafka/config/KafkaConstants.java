package hexagonal.socket.kafka.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties("kafka")
@Data
@ConstructorBinding
public class KafkaConstants {

    public static final String KAFKA_TOPIC = "chat";
    public static final String CONSUMER_GROUP_ID = "chatting";

    @Value("${spring.kafka.consumer.bootstrap-servers}")
    private final String consumerBootStrapServers;

    @Value("${spring.kafka.producer.bootstrap-servers}")
    private String producerBootStrapServers;
}
