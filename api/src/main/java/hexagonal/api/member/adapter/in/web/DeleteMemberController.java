package hexagonal.api.member.adapter.in.web;

import hexagonal.api.member.adapter.in.web.response.DeleteMemberResponse;
import hexagonal.api.member.application.port.in.DeleteMemberCommand;
import hexagonal.api.member.application.port.in.DeleteMemberUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class DeleteMemberController {

    private final DeleteMemberUseCase deleteMemberUseCase;

    @DeleteMapping("/v1/member/{id}")
    ResponseEntity<DeleteMemberResponse> deleteMember(@PathVariable("id") Long id) throws Exception {
        // ToDo 입력모델 Valid Check 예외 처리
        DeleteMemberCommand command = new DeleteMemberCommand(id);
        DeleteMemberResponse deleteMemberResponse = new DeleteMemberResponse(id);
        if (deleteMemberUseCase.deleteMember(command)) {
            return ResponseEntity.ok(deleteMemberResponse);
        } else {
            // ToDo Exception 정의
            throw new Exception();
        }
    }
}
