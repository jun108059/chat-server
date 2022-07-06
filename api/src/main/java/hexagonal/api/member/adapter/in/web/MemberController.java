package hexagonal.api.member.adapter.in.web;

import hexagonal.api.member.adapter.in.web.request.RegisterMemberReq;
import hexagonal.api.member.adapter.in.web.request.UpdateMemberReq;
import hexagonal.api.member.adapter.in.web.response.RegisterMemberResponse;
import hexagonal.api.member.adapter.in.web.response.UpdateMemberResponse;
import hexagonal.api.member.application.port.in.RegisterMemberCommand;
import hexagonal.api.member.application.port.in.RegisterMemberUseCase;
import hexagonal.api.member.application.port.in.UpdateMemberCommand;
import hexagonal.api.member.application.port.in.UpdateMemberUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final RegisterMemberUseCase registerMemberUseCase;
    private final UpdateMemberUseCase updateMemberUseCase;


    @PostMapping("/v1/member")
    ResponseEntity<RegisterMemberResponse> registerMember(@RequestBody RegisterMemberReq memberInfo) {
        // ToDo 입력모델 Valid Check 예외 처리
        RegisterMemberCommand command = new RegisterMemberCommand(
                memberInfo.getName(),
                memberInfo.getEmail(),
                memberInfo.getType());

        Long memberId = registerMemberUseCase.registerMember(command);
        RegisterMemberResponse response = new RegisterMemberResponse(memberId, memberInfo.getEmail());
        // ToDo ResponseEntity + Global Exception 고민
        return ResponseEntity.ok(response);
    }

    @PutMapping("/v1/member")
    ResponseEntity<UpdateMemberResponse> updateMember(@RequestBody UpdateMemberReq memberInfo) {
        // ToDo 입력모델 Valid Check 예외 처리
        UpdateMemberCommand command = new UpdateMemberCommand(
                memberInfo.getId(),
                memberInfo.getName(),
                memberInfo.getEmail(),
                memberInfo.getType());

        Long memId = updateMemberUseCase.updateMember(command);
        UpdateMemberResponse response = new UpdateMemberResponse(memId, memberInfo.getName());
        return ResponseEntity.ok(response);
    }
}
