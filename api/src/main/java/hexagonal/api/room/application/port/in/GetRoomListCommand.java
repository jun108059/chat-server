package hexagonal.api.room.application.port.in;

import lombok.Getter;

@Getter
public class GetRoomListCommand {

    private final Long memId;

    public GetRoomListCommand(Long memId) {
        this.memId = memId;
    }

}
