package hexagonal.api.member.adapter.in.web.response;

import lombok.Data;

@Data
public class RegisterMemberResponse {
    Long id;
    String email;

    public RegisterMemberResponse(Long id, String email) {
        this.id = id;
        this.email = email;
    }
}
