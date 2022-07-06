package hexagonal.api.room.application.port.in;

import hexagonal.core.domain.jpa.RoomJpaEntity;
import lombok.Getter;

@Getter
public class CreateRoomCommand {

    private final Long companyId;
    private final Long adminId;

    public CreateRoomCommand(Long companyId, Long adminId) {
        this.companyId = companyId;
        this.adminId = adminId;
    }

    public RoomJpaEntity toJpaEntity() {
        return RoomJpaEntity.builder()
                .id(null)
                .companyId(companyId)
                .adminId(adminId)
                .build();
    }

}
