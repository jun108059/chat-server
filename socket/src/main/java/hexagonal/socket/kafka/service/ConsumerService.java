package hexagonal.socket.kafka.service;

import hexagonal.socket.kafka.config.KafkaConstants;
import hexagonal.socket.dto.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsumerService {

    private final SimpMessagingTemplate template;

    @KafkaListener(topics = KafkaConstants.KAFKA_TOPIC, groupId = KafkaConstants.CONSUMER_GROUP_ID)
    public void consumerMessage(Message message) {
        System.out.println("chatting : " + message.toString());
        template.convertAndSend("/topic/group", message);
    }
}


