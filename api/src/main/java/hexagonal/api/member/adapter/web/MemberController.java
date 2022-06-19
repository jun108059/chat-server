package hexagonal.api.member.adapter.web;

import hexagonal.api.member.adapter.web.request.RegisterMemberReq;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class MemberController {

    @PostMapping("/member")
    long registerMember(@RequestBody RegisterMemberReq memberInfo) {
        // 입력모델 Valid Check 예외 처리

        // 1. 회원 가입 요청 in port 추가
        // 2. 영속성 out port 추가
        return 0l;
    }
}
