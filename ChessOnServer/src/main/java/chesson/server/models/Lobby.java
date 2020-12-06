package chesson.server.models;

import javax.websocket.Session;
import java.util.ArrayList;
import java.util.List;

public class Lobby {
    private ArrayList<Player> playerList;
    private ArrayList<Session> sessionList;
    private PlayingField playingField;
    private int id;

    public Lobby(int lobbyId, String username) {
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    public List<Session> getSessionList() {
        return sessionList;
    }

    public void setSessionList(ArrayList<Session> sessionList) {
        this.sessionList = sessionList;
    }

    public PlayingField getPlayingField() {
        return playingField;
    }

    public void setPlayingField(PlayingField playingField) {
        this.playingField = playingField;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Player> getPlayers() {
        return playerList;
    }

    public void addPlayer(Player player) {
        playerList.add(player);
    }
}
