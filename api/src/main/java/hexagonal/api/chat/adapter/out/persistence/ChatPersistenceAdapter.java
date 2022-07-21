package hexagonal.api.chat.adapter.out.persistence;

import hexagonal.api.chat.application.port.out.FindChatPort;
import hexagonal.api.chat.application.port.out.SaveChatPort;
import hexagonal.core.domain.jpa.ChatJpaEntity;
import hexagonal.core.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ChatPersistenceAdapter implements SaveChatPort, FindChatPort {

    private final ChatRepository chatRepository;


    @Override
    public Long saveChat(ChatJpaEntity entity) {
        return chatRepository.save(entity).getId();
    }

    @Override
    public List<ChatJpaEntity> findChatByRoom(Long roomId) {
        return chatRepository.findAll();
    }
}
