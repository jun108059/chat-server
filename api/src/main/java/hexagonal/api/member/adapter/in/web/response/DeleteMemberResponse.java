package hexagonal.api.member.adapter.in.web.response;


import lombok.Data;

@Data
public class DeleteMemberResponse {
    Long id;

    public DeleteMemberResponse(Long id) {
        this.id = id;
    }
}
