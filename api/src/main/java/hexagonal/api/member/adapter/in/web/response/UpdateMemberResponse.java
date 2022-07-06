package hexagonal.api.member.adapter.in.web.response;

import lombok.Data;

@Data
public class UpdateMemberResponse {
    Long id;
    String name;

    public UpdateMemberResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
