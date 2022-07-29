package hexagonal.api.chat.adapter.in.web;

import hexagonal.api.chat.adapter.in.web.response.GetChatListRes;
import hexagonal.api.chat.application.port.in.GetChatListQuery;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GetChatListController {

    private final GetChatListQuery getChatListQuery;

    @Operation(summary = "채팅 메시지 조회 요청", description = "채팅방에 있는 채팅 메시지 리스트를 조회합니다.", tags = { "Chat Controller" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @GetMapping("/v1/chat/list/{roomId}")
    ResponseEntity<List<GetChatListRes>> createChat(@PathVariable("roomId") Long roomId) {
        List<GetChatListRes> response = getChatListQuery.getChatList(roomId);
        return ResponseEntity.ok(response);
    }
}
