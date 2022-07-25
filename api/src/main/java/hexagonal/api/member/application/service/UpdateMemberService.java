package hexagonal.api.member.application.service;

import hexagonal.api.member.application.port.in.UpdateMemberCommand;
import hexagonal.api.member.application.port.in.UpdateMemberUseCase;
import hexagonal.api.member.application.port.out.FindMemberPort;
import hexagonal.api.member.application.port.out.UpdateMemberPort;
import hexagonal.core.domain.jpa.MemberJpaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class UpdateMemberService implements UpdateMemberUseCase {

    private final FindMemberPort findMemberPort;
    private final UpdateMemberPort updateMemberPort;

    @Override
    public Long updateMember(UpdateMemberCommand command) {
        MemberJpaEntity jpaEntity = checkMemberExistsById(command.getId());
        if (jpaEntity != null) {
            jpaEntity.setName(command.getName());
            jpaEntity.setType(command.getMemberType());
            return updateMemberPort.updateMember(jpaEntity);
        } else {
            // FixMe Custom Exception 처리하기
            return 0L;
        }
    }

    private MemberJpaEntity checkMemberExistsById(Long id) {
        try {
            return findMemberPort.findMemberById(id);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }
}
