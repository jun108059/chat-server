package hexagonal.api.member.adapter.out.persistence;

import hexagonal.api.member.application.port.out.FindMemberPort;
import hexagonal.api.member.application.port.out.SaveMemberPort;
import hexagonal.core.domain.jpa.MemberJpaEntity;
import hexagonal.core.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
@Component
class MemberPersistenceAdapter implements FindMemberPort, SaveMemberPort {

    private final MemberRepository memberRepository;

    @Override
    public MemberJpaEntity findMember(String email) {
        MemberJpaEntity member = memberRepository.findByEmail(email)
                .orElseThrow(EntityNotFoundException::new);
        return member;
    }


    @Override
    public Long saveMember(MemberJpaEntity memberJpaEntity) {
        MemberJpaEntity saved = memberRepository.save(memberJpaEntity);
        return saved.getId();
    }
}
