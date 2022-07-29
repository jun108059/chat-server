package hexagonal.api.member.adapter.in.web;

import hexagonal.api.member.adapter.in.web.request.RegisterMemberReq;
import hexagonal.api.member.adapter.in.web.response.RegisterMemberResponse;
import hexagonal.api.member.application.port.in.RegisterMemberCommand;
import hexagonal.api.member.application.port.in.RegisterMemberUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegisterMemberController {

    private final RegisterMemberUseCase registerMemberUseCase;

    @Operation(summary = "회원 가입 요청", description = "회원 데이터가 저장됩니다.", tags = { "Member Controller" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
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

}
