package hexagonal.core.repository;

import hexagonal.core.domain.jpa.MemberJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberJpaEntity, Long> {
    Optional<MemberJpaEntity> findByEmail(String email);
}
