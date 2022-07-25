package hexagonal.api.member.adapter.out.persistence;

import hexagonal.api.member.application.port.out.FindMemberPort;
import hexagonal.api.member.application.port.out.SaveMemberPort;
import hexagonal.api.member.application.port.out.UpdateMemberPort;
import hexagonal.core.domain.jpa.MemberJpaEntity;
import hexagonal.core.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RequiredArgsConstructor
@Component
class MemberPersistenceAdapter implements FindMemberPort, SaveMemberPort, UpdateMemberPort {

    private final MemberRepository memberRepository;

    @Override
    public MemberJpaEntity findMemberById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<MemberJpaEntity> findAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public MemberJpaEntity findMemberByEmail(String email) {
        return memberRepository.findByEmail(email)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Long saveMember(MemberJpaEntity memberJpaEntity) {
        MemberJpaEntity saved = memberRepository.save(memberJpaEntity);
        return saved.getId();
    }

    @Override
    public Long updateMember(MemberJpaEntity memberJpaEntity) {
        MemberJpaEntity saveEntity = memberRepository.save(memberJpaEntity);
        return saveEntity.getId();
    }
}
