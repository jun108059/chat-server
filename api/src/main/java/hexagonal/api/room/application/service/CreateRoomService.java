package hexagonal.api.room.application.service;

import hexagonal.api.room.application.port.in.CreateRoomCommand;
import hexagonal.api.room.application.port.in.CreateRoomUseCase;
import hexagonal.api.room.application.port.out.FindRoomPort;
import hexagonal.api.room.application.port.out.SaveRoomPort;
import hexagonal.core.domain.jpa.RoomJpaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class CreateRoomService implements CreateRoomUseCase {

    private final FindRoomPort findRoomPort;
    private final SaveRoomPort saveRoomPort;

    @Override
    public Long createRoom(CreateRoomCommand command) {
        // 중복 채팅방 검사
        if (!checkRoomExists(command.getCompanyId())) {
            RoomJpaEntity roomJpaEntity = command.toJpaEntity();
            return saveRoomPort.saveRoom(roomJpaEntity);
        }
        return null;
    }

    private boolean checkRoomExists(Long companyId) {
        try {
            findRoomPort.findRoomByCompanyId(companyId);
        } catch (EntityNotFoundException e) {
            return false;
        }

        return true;
    }
}
