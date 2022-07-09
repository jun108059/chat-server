package hexagonal.api.member.application.service;

import hexagonal.api.member.application.port.in.RegisterMemberCommand;
import hexagonal.api.member.application.port.out.FindMemberPort;
import hexagonal.api.member.application.port.out.SaveMemberPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.*;

class RegisterMemberServiceTest {

    private final FindMemberPort findMemberPort =
            Mockito.mock(FindMemberPort.class);

    private final SaveMemberPort saveMemberPort =
            Mockito.mock(SaveMemberPort.class);

    RegisterMemberService registerMemberService = new RegisterMemberService(findMemberPort, saveMemberPort);

    @Test
    @DisplayName("회원가입 유스케이스 테스트")
    void 회원가입_테스트() {
        // given
        String name = "테스트_영준";
        String email = "test@test.com";
        String type = "USER";

        RegisterMemberCommand command = new RegisterMemberCommand(name, email, type);

        // when
        Long memberId = registerMemberService.registerMember(command);

        // then
        assertThat(memberId).isEqualTo(-1L);
    }

}