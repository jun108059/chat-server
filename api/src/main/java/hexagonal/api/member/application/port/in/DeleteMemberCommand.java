package hexagonal.api.member.application.port.in;

import lombok.Getter;

@Getter
public class DeleteMemberCommand {

    private final Long id;

    public DeleteMemberCommand(Long id) {
        // 존재하는 ID 검사는 어디서 할까
        this.id = id;
    }

}
