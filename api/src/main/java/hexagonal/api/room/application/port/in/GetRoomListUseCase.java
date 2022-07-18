package hexagonal.api.room.application.port.in;

import hexagonal.api.room.adapter.in.web.response.GetRoomRes;

import java.util.List;

public interface GetRoomListUseCase {
    List<GetRoomRes> getRoomList();
}
