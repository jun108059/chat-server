package hexagonal.api.room.adapter.in.web.request;

import lombok.Getter;

@Getter
public class CreateRoomReq {
    Long companyId;
    Long adminId;
}
