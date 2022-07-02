package hexagonal.api.room.application.port.in;

public interface CreateRoomUseCase {
    Long createRoom(CreateRoomCommand command);
}
