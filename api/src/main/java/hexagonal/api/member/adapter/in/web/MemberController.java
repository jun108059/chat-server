package hexagonal.api.member.adapter.in.web;

import hexagonal.api.member.adapter.in.web.request.RegisterMemberReq;
import hexagonal.api.member.adapter.in.web.response.RegisterMemberResponse;
import hexagonal.api.member.application.port.in.RegisterMemberCommand;
import hexagonal.api.member.application.port.in.RegisterMemberUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final RegisterMemberUseCase registerMemberUseCase;

    @PostMapping("/v1/member")
    ResponseEntity<RegisterMemberResponse> registerMember(@RequestBody RegisterMemberReq memberInfo) {
        // ToDo 입력모델 Valid Check 예외 처리
        RegisterMemberCommand command = new RegisterMemberCommand(
                memberInfo.getName(),
                memberInfo.getEmail(),
                memberInfo.getType());

        Long memberId = registerMemberUseCase.registerMember(command);
        RegisterMemberResponse response = new RegisterMemberResponse(memberId, memberInfo.getEmail());
        // Todo ResponseEntity + Global Exception 고민
        return ResponseEntity.ok(response);
    }
}
