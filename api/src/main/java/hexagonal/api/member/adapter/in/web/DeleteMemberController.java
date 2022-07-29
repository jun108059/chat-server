package hexagonal.api.member.adapter.in.web;

import hexagonal.api.member.adapter.in.web.response.DeleteMemberResponse;
import hexagonal.api.member.application.port.in.DeleteMemberCommand;
import hexagonal.api.member.application.port.in.DeleteMemberUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class DeleteMemberController {

    private final DeleteMemberUseCase deleteMemberUseCase;

    @Operation(summary = "회원 탈퇴 요청", description = "회원 정보가 삭제됩니다.", tags = { "Member Controller" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK",
                content = @Content(schema = @Schema(implementation = DeleteMemberResponse.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @DeleteMapping("/v1/member/{id}")
    ResponseEntity<DeleteMemberResponse> deleteMember(
            @Parameter(description = "회원 ID", required = true, example = "1") @PathVariable("id") Long id) throws Exception {
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
