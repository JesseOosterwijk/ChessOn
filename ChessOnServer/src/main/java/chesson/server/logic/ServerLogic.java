package chesson.server.logic;

import chesson.server.models.Lobby;
import chesson.server.models.Player;
import chesson.server.models.PlayingField;
import chesson.server.models.pieces.Piece;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServerLogic {
    private ArrayList<Lobby> lobbies = new ArrayList<>();

    public int createLobbyAndReturnId(String username) {
        int lobbyId = lobbies.size() + 1;
        lobbies.add(new Lobby(lobbyId, username));
        return lobbyId;
    }

    public Player createPlayer(String username){
        List<Piece> pieces = new ArrayList<>();
        return new Player(username, 500, pieces);
    }

    public Lobby getLobby(int lobbyId) {
        return lobbies.stream().filter(lobby -> lobby.getId() == lobbyId).findFirst().get();
    }

    public ArrayList<Player> getPlayers(int lobbyId) {
        return getLobby(lobbyId).getPlayers();
    }

    public void joinLobby(int lobbyId, String username) {
        getLobby(lobbyId).addPlayer(createPlayer(username));
    }

    public PlayingField getPlayingField(int lobbyId) {
        return getLobby(lobbyId).getPlayingField();
    }
}
