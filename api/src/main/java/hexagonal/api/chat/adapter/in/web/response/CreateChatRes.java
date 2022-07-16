package hexagonal.api.chat.adapter.in.web.response;

import lombok.Data;

@Data
public class CreateChatRes {
    Long roomId;

    public CreateChatRes(Long roomId) {
        this.roomId = roomId;
    }
}
