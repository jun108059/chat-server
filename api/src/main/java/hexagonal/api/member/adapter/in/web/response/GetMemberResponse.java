package hexagonal.api.member.adapter.in.web.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class GetMemberResponse {

    private Long id;
    private String name;
    private String email;
    private String type;
}
