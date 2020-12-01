package chesson.server.models;

import javax.websocket.Session;
import java.util.List;

public class Lobby {
    private List<Player> playerList;
    private List<Session> sessionList;
    private PlayingField playingField;
}
