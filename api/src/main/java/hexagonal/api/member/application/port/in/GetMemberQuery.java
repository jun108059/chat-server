package hexagonal.api.member.application.port.in;

import hexagonal.core.domain.Member;

import java.util.List;

public interface GetMemberQuery {

    List<Member> getMemberList();
}
