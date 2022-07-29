package hexagonal.api.room.adapter.in.web;

import hexagonal.api.room.adapter.in.web.request.CreateRoomReq;
import hexagonal.api.room.adapter.in.web.response.CreateRoomRes;
import hexagonal.api.room.application.port.in.CreateRoomCommand;
import hexagonal.api.room.application.port.in.CreateRoomUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CreateRoomController {

    private final CreateRoomUseCase createRoomUseCase;

    @Operation(summary = "채팅방 생성 요청", description = "채팅방 데이터가 생성됩니다.", tags = { "Room Controller" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
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
