package hexagonal.api.member.application.port.out;

import hexagonal.core.domain.jpa.MemberJpaEntity;

public interface SaveMemberPort {
    Long saveMember(MemberJpaEntity memberJpaEntity);
}
