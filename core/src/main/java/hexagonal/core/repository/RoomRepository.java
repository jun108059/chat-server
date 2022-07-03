package hexagonal.core.repository;

import hexagonal.core.domain.jpa.RoomJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<RoomJpaEntity, Long> {
    Optional<RoomJpaEntity> findByCompanyId(Long companyId);
}
