package hexagonal.api.chat.adapter.in.web.request;

import hexagonal.api.chat.application.port.in.CreateChatCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateChatReq {
    private String content;
    private Long senderId;
    private Long roomId;

    public CreateChatCommand toCommand() {
        return new CreateChatCommand(this.content, this.senderId, this.roomId);
    }
}
