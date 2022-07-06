package hexagonal.api.member.application.port.out;

import hexagonal.core.domain.jpa.MemberJpaEntity;

public interface FindMemberPort {

    MemberJpaEntity findMemberByEmail(String email);

    MemberJpaEntity findMemberById(Long id);
}
