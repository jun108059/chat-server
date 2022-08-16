package hexagonal.socket.service;

import hexagonal.socket.dto.RoomInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatRoomService {

    private final WebClient webClient = WebClient.builder()
            .baseUrl("http://localhost:8080")
            .build();

    public List<RoomInfo> getRoomInfoList() {
        return webClient.get()
                .uri("/v1/room/list")
                .retrieve()
                .bodyToFlux(RoomInfo.class)
                .toStream()
                .collect(Collectors.toList());
    }
}
