package hexagonal.api.member.application.port.in;

import hexagonal.core.domain.jpa.MemberJpaEntity;
import lombok.Getter;

@Getter
public class UpdateMemberCommand {

    private final Long id;
    private final String name;
    private final String email;
    private final String memberType;

    public UpdateMemberCommand(Long id, String name, String email, String type) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.memberType = type;
    }

    public MemberJpaEntity toJpaEntity() {
        return MemberJpaEntity.builder()
                .id(id)
                .name(name)
                .email(email)
                .type(memberType)
                .build();
    }

}
