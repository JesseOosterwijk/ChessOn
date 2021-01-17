package rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rest.models.Player;

import java.util.UUID;

public interface IPlayerRepository extends JpaRepository<Player, UUID> {
    Player findPlayerByName(String name);
}
