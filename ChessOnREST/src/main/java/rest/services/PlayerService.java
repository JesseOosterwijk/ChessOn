package rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.models.Player;
import rest.repositories.IPlayerRepository;

@Service
public class PlayerService {

    @Autowired
    public IPlayerRepository playerRepository;

    public void savePlayer(Player player) {
        playerRepository.save(player);
    }
}
