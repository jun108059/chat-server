package hexagonal.api.member.application.port.in;

public interface DeleteMemberUseCase {

    Boolean deleteMember(DeleteMemberCommand command);
}
