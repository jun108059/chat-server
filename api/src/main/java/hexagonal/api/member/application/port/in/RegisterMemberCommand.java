package hexagonal.api.member.application.port.in;

import hexagonal.core.domain.jpa.MemberJpaEntity;
import lombok.Getter;

@Getter
public class RegisterMemberCommand {

    private final String name;
    private final String email;
    private final String memberType;

    public RegisterMemberCommand(String name, String email, String type) {
        this.name = name;
        this.email = email;
        this.memberType = type;
        // MemberType ENUM String 일치 입력 유효성 검증
        // name Validation 추가
    }

    public MemberJpaEntity toJpaEntity() {
        return MemberJpaEntity.builder()
                .id(null)
                .name(name)
                .email(email)
                .type(memberType)
                .build();
    }

}
