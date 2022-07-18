package hexagonal.api.room.adapter.in.web.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetRoomRes {

    Long id;
    Long companyId;
    String companyName;

    public GetRoomRes(Long id, Long companyId, String companyName) {
        this.id = id;
        this.companyId = companyId;
        this.companyName = companyName;
    }
}
