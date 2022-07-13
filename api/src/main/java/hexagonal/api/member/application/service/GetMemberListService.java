package hexagonal.api.member.application.service;

import hexagonal.api.member.adapter.in.web.response.GetMemberResponse;
import hexagonal.api.member.application.port.in.GetMemberListQuery;
import hexagonal.api.member.application.port.out.FindMemberPort;
import hexagonal.api.room.util.Translator;
import hexagonal.core.domain.jpa.MemberJpaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetMemberListService implements GetMemberListQuery {

    private final FindMemberPort findMemberPort;

    @Override
    public List<GetMemberResponse> getMemberList() {
        List<MemberJpaEntity> allMembers = findMemberPort.findAllMembers();

        List<GetMemberResponse> responses = new ArrayList<>();
        for (MemberJpaEntity allMember : allMembers) {
            GetMemberResponse getMemberResponse = Translator.toGetMemberResDto(allMember);
            responses.add(getMemberResponse);
        }

        return responses;
    }
}
