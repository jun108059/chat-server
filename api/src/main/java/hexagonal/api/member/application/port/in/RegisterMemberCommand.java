package hexagonal.api.member.application.port.in;

public class RegisterMemberCommand {

    private final String name;
    private final String memberType;

    public RegisterMemberCommand(String name, String type) {
        this.name = name;
        this.memberType = type;
        // MemberType ENUM String 일치 입력 유효성 검증
        // name Validation 추가
    }

}
