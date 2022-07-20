package hexagonal.api.chat.adapter.in.web.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class GetChatListRes {
    private Long id;
    private String content;
    private Long senderId;
    private Long roomId;

}
