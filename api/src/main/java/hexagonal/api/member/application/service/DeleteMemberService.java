package hexagonal.api.member.application.service;

import hexagonal.api.member.application.port.in.DeleteMemberCommand;
import hexagonal.api.member.application.port.in.DeleteMemberUseCase;
import hexagonal.api.member.application.port.in.UpdateMemberCommand;
import hexagonal.api.member.application.port.in.UpdateMemberUseCase;
import hexagonal.api.member.application.port.out.DeleteMemberPort;
import hexagonal.api.member.application.port.out.FindMemberPort;
import hexagonal.api.member.application.port.out.UpdateMemberPort;
import hexagonal.core.domain.jpa.MemberJpaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class DeleteMemberService implements DeleteMemberUseCase {

    private final FindMemberPort findMemberPort;
    private final DeleteMemberPort deleteMemberPort;

    private boolean checkMemberExistsById(Long id) {
        try {
            findMemberPort.findMemberById(id);
        } catch (EntityNotFoundException e) {
            return false;
        }

        return true;
    }

    @Override
    public Boolean deleteMember(DeleteMemberCommand command) {
        // ID 존재 여부 검사
        if (checkMemberExistsById(command.getId())) {
            return deleteMemberPort.deleteMember(command.getId());
        } else {
            // FixMe Custom Exception 처리하기
            return false;
        }
    }
}
