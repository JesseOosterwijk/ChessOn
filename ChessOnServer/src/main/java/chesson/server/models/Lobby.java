package chesson.server.models;

import javax.websocket.Session;
import java.util.List;

public class Lobby {
    private List<Player> playerList;
    private List<Session> sessionList;
    private PlayingField playingField;

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public List<Session> getSessionList() {
        return sessionList;
    }

    public void setSessionList(List<Session> sessionList) {
        this.sessionList = sessionList;
    }

    public PlayingField getPlayingField() {
        return playingField;
    }

    public void setPlayingField(PlayingField playingField) {
        this.playingField = playingField;
    }
}
