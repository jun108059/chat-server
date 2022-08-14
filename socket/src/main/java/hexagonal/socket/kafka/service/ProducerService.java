package hexagonal.socket.kafka.service;

import hexagonal.socket.kafka.config.KafkaConstants;
import hexagonal.socket.dto.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class ProducerService {

    private final KafkaTemplate<String, Message> kafkaTemplate;

    public void sendMessage(Message message) {
        System.out.println("message = " + message.toString());
        try {
            kafkaTemplate.send(KafkaConstants.KAFKA_TOPIC, message).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}