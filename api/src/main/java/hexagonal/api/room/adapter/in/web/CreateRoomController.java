package hexagonal.api.room.adapter.in.web;

import hexagonal.api.room.adapter.in.web.request.CreateRoomReq;
import hexagonal.api.room.adapter.in.web.response.CreateRoomRes;
import hexagonal.api.room.application.port.in.CreateRoomCommand;
import hexagonal.api.room.application.port.in.CreateRoomUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CreateRoomController {

    private final CreateRoomUseCase createRoomUseCase;

    @PostMapping("/v1/room")
    ResponseEntity<CreateRoomRes> createRoom(@RequestBody CreateRoomReq roomReq) {
        CreateRoomCommand command = new CreateRoomCommand(
                roomReq.getCompanyId(),
                roomReq.getAdminId());

        Long roomId = createRoomUseCase.createRoom(command);
        CreateRoomRes response = new CreateRoomRes(roomId, roomReq.getCompanyId());
        return ResponseEntity.ok(response);
    }
}
