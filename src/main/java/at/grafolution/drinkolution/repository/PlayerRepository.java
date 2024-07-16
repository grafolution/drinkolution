package at.grafolution.drinkolution.repository;

import at.grafolution.drinkolution.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findBySessionId(String sessionId);
}