package hexagonal.api.chat.application.port.out;

import hexagonal.core.domain.jpa.ChatJpaEntity;

import java.util.List;

public interface FindChatPort {
    List<ChatJpaEntity> findChatByRoom(Long roomId);

}
