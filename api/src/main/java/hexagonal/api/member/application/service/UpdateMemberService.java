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
        // ID 존재 여부 검사
        if (checkMemberExistsById(command.getId())) {
            MemberJpaEntity memberJpaEntity = command.toJpaEntity();
            return updateMemberPort.updateMember(memberJpaEntity);
        } else {
            // FixMe Custom Exception 처리하기
            return null;
        }
    }

    private boolean checkMemberExistsById(Long id) {
        try {
            findMemberPort.findMemberById(id);
        } catch (EntityNotFoundException e) {
            return false;
        }

        return true;
    }
}
