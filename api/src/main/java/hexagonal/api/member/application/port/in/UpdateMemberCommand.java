package hexagonal.api.member.application.port.in;

import lombok.Getter;

@Getter
public class UpdateMemberCommand {

    private final Long id;
    private final String name;
    private final String memberType;

    public UpdateMemberCommand(Long id, String name, String type) {
        this.id = id;
        this.name = name;
        this.memberType = type;
    }

}
