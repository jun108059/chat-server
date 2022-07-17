package hexagonal.api.chat.application.port.out;

import hexagonal.core.domain.jpa.ChatJpaEntity;

public interface SaveChatPort {
    Long saveChat(ChatJpaEntity entity);

}
