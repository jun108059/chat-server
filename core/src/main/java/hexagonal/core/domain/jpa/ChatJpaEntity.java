package hexagonal.core.domain.jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "chat")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatJpaEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String content;

    @Column
    private Long senderId;

    @Column
    private Long roomId;
}
