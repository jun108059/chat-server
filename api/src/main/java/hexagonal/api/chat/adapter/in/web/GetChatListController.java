package hexagonal.api.chat.adapter.in.web;

import hexagonal.api.chat.adapter.in.web.response.GetChatListRes;
import hexagonal.api.chat.application.port.in.GetChatListQuery;
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

    @GetMapping("/v1/chat/list/{roomId}")
    ResponseEntity<List<GetChatListRes>> createChat(@PathVariable("roomId") Long roomId) {
        List<GetChatListRes> response = getChatListQuery.getChatList(roomId);
        return ResponseEntity.ok(response);
    }
}
