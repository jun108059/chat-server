package hexagonal.api.chat.application.port.in;

import hexagonal.core.domain.jpa.ChatJpaEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateChatCommand {

    private final String content;
    private final Long senderId;
    private final Long roomId;

    public ChatJpaEntity toJpaEntity() {
        return new ChatJpaEntity(null, this.content, this.senderId, this.roomId);
    }
}
