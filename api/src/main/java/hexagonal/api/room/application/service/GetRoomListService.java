package hexagonal.api.room.application.service;

import hexagonal.api.member.application.port.out.FindMemberPort;
import hexagonal.api.room.adapter.in.web.response.GetRoomRes;
import hexagonal.api.room.application.port.in.GetRoomListUseCase;
import hexagonal.api.room.application.port.out.FindRoomPort;
import hexagonal.api.room.util.Translator;
import hexagonal.core.domain.jpa.RoomJpaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetRoomListService implements GetRoomListUseCase {

    private final FindRoomPort findRoomPort;
    private final FindMemberPort findMemberPort;

    @Override
    public List<GetRoomRes> getRoomList() {
        List<RoomJpaEntity> roomList = findRoomPort.findRoomList();

        List<GetRoomRes> response = new ArrayList<>();
        for (RoomJpaEntity roomJpaEntity : roomList) {
            Long companyId = roomJpaEntity.getCompanyId();
            String companyName = findMemberPort.findMemberById(companyId).getName();
            GetRoomRes getRoomRes = Translator.toGetRoomResDto(roomJpaEntity, companyName);
            response.add(getRoomRes);
        }

        return response;
    }
}
