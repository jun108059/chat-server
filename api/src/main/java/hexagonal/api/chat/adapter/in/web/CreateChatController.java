package hexagonal.api.chat.adapter.in.web;

import hexagonal.api.chat.adapter.in.web.request.CreateChatReq;
import hexagonal.api.chat.adapter.in.web.response.CreateChatRes;
import hexagonal.api.chat.application.port.in.CreateChatCommand;
import hexagonal.api.chat.application.port.in.CreateChatUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CreateChatController {

    private final CreateChatUseCase createChatUseCase;

    @PostMapping("/v1/chat")
    ResponseEntity<CreateChatRes> createChat(@RequestBody CreateChatReq roomReq) {
        CreateChatCommand command = roomReq.toCommand();
        Boolean createOk = createChatUseCase.createChat(command);
        // ToDo Exception 정의하기
        CreateChatRes response = new CreateChatRes(command.getRoomId());
        return ResponseEntity.ok(response);
    }
}
