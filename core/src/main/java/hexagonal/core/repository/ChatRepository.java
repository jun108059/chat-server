package hexagonal.core.repository;

import hexagonal.core.domain.jpa.ChatJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<ChatJpaEntity, Long> {

}
