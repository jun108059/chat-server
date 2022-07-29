package hexagonal.api.room.adapter.in.web;

import hexagonal.api.room.adapter.in.web.response.GetRoomRes;
import hexagonal.api.room.application.port.in.GetRoomListUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GetRoomListController {

    private final GetRoomListUseCase getRoomListUseCase;

    @Operation(summary = "채팅방 조회 요청", description = "채팅방 데이터가 조회됩니다.", tags = { "Room Controller" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @GetMapping("/v1/room/list")
    ResponseEntity<List<GetRoomRes>> getRoomList() {
        List<GetRoomRes> response = getRoomListUseCase.getRoomList();
        return ResponseEntity.ok(response);
    }
}
