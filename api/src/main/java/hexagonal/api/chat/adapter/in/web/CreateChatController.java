package hexagonal.api.chat.adapter.in.web;

import hexagonal.api.chat.adapter.in.web.request.CreateChatReq;
import hexagonal.api.chat.adapter.in.web.response.CreateChatRes;
import hexagonal.api.chat.application.port.in.CreateChatCommand;
import hexagonal.api.chat.application.port.in.CreateChatUseCase;
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
public class CreateChatController {

    private final CreateChatUseCase createChatUseCase;

    @Operation(summary = "채팅 메시지 생성 요청", description = "채팅 메시지를 생성합니다.", tags = { "Chat Controller" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @PostMapping("/v1/chat")
    ResponseEntity<CreateChatRes> createChat(@RequestBody CreateChatReq roomReq) {
        CreateChatCommand command = roomReq.toCommand();
        Boolean createOk = createChatUseCase.createChat(command);
        // ToDo Exception 정의하기
        CreateChatRes response = new CreateChatRes(command.getRoomId());
        return ResponseEntity.ok(response);
    }
}
