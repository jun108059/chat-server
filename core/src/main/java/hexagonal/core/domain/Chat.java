package hexagonal.core.domain;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Chat {

    private Long id;
    private String content;
    private Long senderId;
    private Long roomId;

}
