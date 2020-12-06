package chesson.server.logic;

import chesson.server.models.Lobby;
import chesson.server.models.Player;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ServerLogic {
    private ArrayList<Lobby> lobbies = new ArrayList<>();

    public int createLobbyAndReturnId(String username) {
        int lobbyId = lobbies.size() + 1;
        lobbies.add(new Lobby(lobbyId, username));
        return lobbyId;
    }

    private Lobby getLobby(int lobbyId) {
        return lobbies.stream().filter(lobby -> lobby.getId() == lobbyId).findFirst().get();
    }

    public ArrayList<Player> getPlayers(int lobbyId) {
        return getLobby(lobbyId).getPlayers();
    }

    public void joinLobby(int lobbyId, Player player) {
        getLobby(lobbyId).addPlayer(player);
    }
}
