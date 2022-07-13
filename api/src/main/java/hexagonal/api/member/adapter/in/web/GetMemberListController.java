package hexagonal.api.member.adapter.in.web;

import hexagonal.api.member.adapter.in.web.response.GetMemberResponse;
import hexagonal.api.member.application.port.in.GetMemberListQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GetMemberListController {

    private final GetMemberListQuery getMemberListQuery;

    @GetMapping("/v1/member/list")
    ResponseEntity<List<GetMemberResponse>> getRoomList() {
        List<GetMemberResponse> response = getMemberListQuery.getMemberList();
        return ResponseEntity.ok(response);
    }
}
