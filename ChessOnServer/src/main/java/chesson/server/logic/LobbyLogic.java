package chesson.server.logic;

import chesson.server.models.Lobby;
import chesson.server.models.Player;
import chesson.server.models.PlayingField;
import chesson.server.models.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class LobbyLogic {
    private ArrayList<Lobby> lobbies = new ArrayList<>();

    public int createLobbyAndReturnId(String username) {
        int lobbyId = lobbies.size() + 1;
        lobbies.add(new Lobby(lobbyId, username));
        return lobbyId;
    }

    public PlayingField getPlayingField(int lobbyId) {
        return getLobby(lobbyId).getPlayingField();
    }

    public Lobby getLobby(int lobbyId) {
        return lobbies.stream().filter(lobby -> lobby.getId() == lobbyId).findFirst().get();
    }

}
