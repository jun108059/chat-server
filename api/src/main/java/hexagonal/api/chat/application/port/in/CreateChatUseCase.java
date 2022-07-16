package hexagonal.api.chat.application.port.in;

public interface CreateChatUseCase {

    Boolean createChat(CreateChatCommand command);
}
