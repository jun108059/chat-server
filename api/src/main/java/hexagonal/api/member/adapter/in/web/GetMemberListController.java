package hexagonal.api.member.adapter.in.web;

import hexagonal.api.member.adapter.in.web.response.GetMemberResponse;
import hexagonal.api.member.application.port.in.GetMemberListQuery;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GetMemberListController {

    private final GetMemberListQuery getMemberListQuery;

    @Operation(summary = "회원 리스트 요청", description = "전체 회원 리스트를 조회합니다.", tags = { "Member Controller" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @GetMapping("/v1/member/list")
    ResponseEntity<List<GetMemberResponse>> getRoomList() {
        List<GetMemberResponse> response = getMemberListQuery.getMemberList();
        return ResponseEntity.ok(response);
    }
}
