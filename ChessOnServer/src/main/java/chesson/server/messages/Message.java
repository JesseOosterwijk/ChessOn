package chesson.server.messages;

import chesson.server.enums.MessageType;
import chesson.server.models.Player;
import chesson.server.models.pieces.Piece;

import java.util.ArrayList;

public class Message {
    public String to;
    public int lobbyId;
    public String username;
    public MessageType messageType;
    public ArrayList<Player> players;
    public Player host;
    public ArrayList<Piece> pieces;

    public Message() {
    }
}
