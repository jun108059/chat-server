package hexagonal.core.domain.jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "room")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomJpaEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Long companyId;

    @Column
    private Long adminId;

}
