package hexagonal.api.room.adapter.in.web.response;

import lombok.Data;

@Data
public class CreateRoomRes {
    Long id;
    Long companyId;

    public CreateRoomRes(Long id, Long companyId) {
        this.id = id;
        this.companyId = companyId;
    }
}
