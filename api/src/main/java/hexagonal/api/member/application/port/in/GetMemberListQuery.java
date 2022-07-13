package hexagonal.api.member.application.port.in;

import hexagonal.api.member.adapter.in.web.response.GetMemberResponse;
import hexagonal.core.domain.Member;

import java.util.List;

public interface GetMemberListQuery {

    List<GetMemberResponse> getMemberList();
}
