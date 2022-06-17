package hexagonal.api.member.application.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class MemberController {

    @PostMapping("/member")
    long registerMember(@RequestBody RegisterMemberReq memberInfo) {
        // 회원 가입 요청 in port 추가
        // 영속성 out port 추가
    }
}
