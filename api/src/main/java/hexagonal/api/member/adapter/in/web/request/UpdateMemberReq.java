package hexagonal.api.member.adapter.in.web.request;

import lombok.Getter;

@Getter
public class UpdateMemberReq {

    Long id;
    String name;
    String email;
    String type;
}
