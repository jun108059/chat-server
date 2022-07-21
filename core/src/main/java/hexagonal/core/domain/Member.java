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

    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Column(nullable = false, length = 30)
    @Enumerated(EnumType.STRING)
    private MemberType type;

    /**
     * 채팅 메시지 전송
     *
     * @param roomId 방 번호
     * @param chatContent 메시지 내용
     * @return 메시지 전송 완료 여부
     */
    public boolean sendChat(Long roomId, String chatContent) {
        Chat chat = Chat.builder()
                .senderId(this.id)
                .roomId(roomId)
                .content(chatContent)
                .build();
        // Kafka 메시지 발송
        // Message 저장
        return true;
    }

    public enum MemberType {
        USER ,COMPANY, ADMIN
    }
}
