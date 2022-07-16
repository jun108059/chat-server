package hexagonal.api.chat.application.service;

import hexagonal.api.chat.application.port.in.CreateChatCommand;
import hexagonal.api.chat.application.port.in.CreateChatUseCase;
import hexagonal.api.chat.application.port.out.SaveChatPort;
import hexagonal.core.domain.jpa.ChatJpaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateChatService implements CreateChatUseCase {

    private final SaveChatPort saveChatPort;

    @Override
    public Boolean createChat(CreateChatCommand command) {
        ChatJpaEntity chatJpaEntity = command.toJpaEntity();
        Long chatId = saveChatPort.saveChat(chatJpaEntity);
        return chatId > 0;
    }
}
