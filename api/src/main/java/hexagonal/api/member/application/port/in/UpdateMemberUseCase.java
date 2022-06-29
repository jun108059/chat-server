package hexagonal.api.member.application.port.in;

public interface UpdateMemberUseCase {

    Long updateMember(UpdateMemberCommand command);
}
