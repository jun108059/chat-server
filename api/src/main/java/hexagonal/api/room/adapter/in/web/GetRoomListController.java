package hexagonal.api.room.adapter.in.web;

import hexagonal.api.room.adapter.in.web.response.GetRoomRes;
import hexagonal.api.room.application.port.in.GetRoomListUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GetRoomListController {

    private final GetRoomListUseCase getRoomListUseCase;

    @GetMapping("/v1/room/list")
    ResponseEntity<List<GetRoomRes>> getRoomList() {
        List<GetRoomRes> response = getRoomListUseCase.getRoomList();
        return ResponseEntity.ok(response);
    }
}
