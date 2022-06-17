package hexagonal.core.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 30)
    private MemberType type;

    /**
     * 채팅 메시지 전송
     *
     * @param roomId 방 번호
     * @param messageContent 메시지 내용
     * @return 메시지 전송 완료 여부
     */
    public boolean sendMessage(Long roomId, String messageContent) {
        Message message = Message.builder()
                .senderId(this.id)
                .roomId(roomId)
                .content(messageContent)
                .build();
        // Kafka 메시지 발송
        // Message 저장
        return true;
    }

    public enum MemberType {
        USER ,COMPANY, ADMIN
    }
}
