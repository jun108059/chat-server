package hexagonal.api.member.adapter.in.web.request;

import lombok.Getter;

@Getter
public class RegisterMemberReq {
    String name;
    String email;
    String type;
}
