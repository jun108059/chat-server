package hexagonal.socket.dto;

import lombok.*;
import org.springframework.lang.Nullable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Message {
    public enum MessageType {
        ENTER, TALK
    }

    @Nullable
    private MessageType type;
    //채팅방 ID
    private String roomId;
    //보내는 사람
    private String sender;
    //내용
    private String content;

    private String timestamp;
}
