package hexagonal.api.room.application.port.out;

import hexagonal.core.domain.jpa.RoomJpaEntity;

import java.util.List;

public interface FindRoomPort {
    RoomJpaEntity findRoomByCompanyId(Long companyId);
    List<RoomJpaEntity> findRoomList();

}
