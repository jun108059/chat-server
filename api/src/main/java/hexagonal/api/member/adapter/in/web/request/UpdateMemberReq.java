package hexagonal.api.member.adapter.in.web.request;

import lombok.Getter;

@Getter
public class UpdateMemberReq {
    String name;
    String type;
}
