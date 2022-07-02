package hexagonal.api.member.application.port.out;

import hexagonal.core.domain.jpa.MemberJpaEntity;

public interface UpdateMemberPort {
    Long updateMember(MemberJpaEntity memberJpaEntity);
}
