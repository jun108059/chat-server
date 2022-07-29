package hexagonal.api.member.adapter.in.web;

import hexagonal.api.member.adapter.in.web.request.UpdateMemberReq;
import hexagonal.api.member.adapter.in.web.response.UpdateMemberResponse;
import hexagonal.api.member.application.port.in.UpdateMemberCommand;
import hexagonal.api.member.application.port.in.UpdateMemberUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UpdateMemberController {

    private final UpdateMemberUseCase updateMemberUseCase;

    @Operation(summary = "회원 정보 수정 요청", description = "회원 데이터가 수정됩니다.", tags = { "Member Controller" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
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
