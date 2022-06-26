package hexagonal.api.member.application.service;

import hexagonal.api.member.application.port.in.RegisterMemberCommand;
import hexagonal.api.member.application.port.in.RegisterMemberUseCase;
import hexagonal.api.member.application.port.out.FindMemberPort;
import hexagonal.api.member.application.port.out.SaveMemberPort;
import hexagonal.core.domain.jpa.MemberJpaEntity;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
public class RegisterMemberService implements RegisterMemberUseCase {

    private final FindMemberPort findMemberPort;
    private final SaveMemberPort saveMemberPort;

    @Override
    public Long registerMember(RegisterMemberCommand command) {
        // 중복 이메일 검사
        if (!checkMemberEmailExists(command.getEmail())) {
            // ToDo Global Exception
            return -1L;
        }
        MemberJpaEntity memberJpaEntity = command.toJpaEntity();
        // 모델 상태 조작
        Long memberId = saveMemberPort.saveMember(memberJpaEntity);
        // 출력 값 반환
        return memberId;
    }

    private boolean checkMemberEmailExists(String email) {
        try {
            findMemberPort.findMember(email);
        } catch (EntityNotFoundException e) {
            return true;
        }

        return false;
    }

}
