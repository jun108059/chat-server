package hexagonal.api.member.application.port.out;

import hexagonal.core.domain.jpa.MemberJpaEntity;

import java.util.List;

public interface FindMemberPort {

    MemberJpaEntity findMemberByEmail(String email);

    MemberJpaEntity findMemberById(Long id);

    List<MemberJpaEntity> findAllMembers();
}
