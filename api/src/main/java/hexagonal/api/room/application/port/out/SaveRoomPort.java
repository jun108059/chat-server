package hexagonal.api.room.application.port.out;

import hexagonal.core.domain.jpa.RoomJpaEntity;

public interface SaveRoomPort {
    Long saveRoom(RoomJpaEntity roomJpaEntity);
}
