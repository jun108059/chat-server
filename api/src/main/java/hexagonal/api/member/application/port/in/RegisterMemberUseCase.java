package hexagonal.api.member.application.port.in;

public interface RegisterMemberUseCase {

    Long registerMember(RegisterMemberCommand command);
}
