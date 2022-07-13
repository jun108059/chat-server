package hexagonal.api.member.adapter.in.web;

import hexagonal.api.member.adapter.in.web.request.UpdateMemberReq;
import hexagonal.api.member.adapter.in.web.response.UpdateMemberResponse;
import hexagonal.api.member.application.port.in.UpdateMemberCommand;
import hexagonal.api.member.application.port.in.UpdateMemberUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UpdateMemberController {

    private final UpdateMemberUseCase updateMemberUseCase;

    @PutMapping("/v1/member/{id}")
    ResponseEntity<UpdateMemberResponse> updateMember(@RequestBody UpdateMemberReq memberInfo,
                                                      @PathVariable("id") Long id) {
        // ToDo 입력모델 Valid Check 예외 처리
        UpdateMemberCommand command = new UpdateMemberCommand(
                id,
                memberInfo.getName(),
                memberInfo.getType());

        Long memId = updateMemberUseCase.updateMember(command);
        UpdateMemberResponse response = new UpdateMemberResponse(memId, memberInfo.getName());
        return ResponseEntity.ok(response);
    }
}
