package hexagonal.api.room.adapter.out.persistence;

import hexagonal.api.room.application.port.out.FindRoomPort;
import hexagonal.api.room.application.port.out.SaveRoomPort;
import hexagonal.core.domain.jpa.RoomJpaEntity;
import hexagonal.core.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RequiredArgsConstructor
@Component
class RoomPersistenceAdapter implements FindRoomPort, SaveRoomPort {

    private final RoomRepository roomRepository;

    @Override
    public RoomJpaEntity findRoomByCompanyId(Long companyId) {
        return roomRepository.findByCompanyId(companyId)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<RoomJpaEntity> findRoomList() {
        return roomRepository.findAll();
    }

    @Override
    public Long saveRoom(RoomJpaEntity roomJpaEntity) {
        return roomRepository.save(roomJpaEntity).getId();
    }
}
