package chesson.server.messages;

import chesson.server.enums.MessageType;
import chesson.server.models.Player;
import chesson.server.models.PlayingField;
import chesson.server.models.Square;
import chesson.server.models.pieces.Piece;

import java.util.ArrayList;

public class PlayingFieldMessage {
    public String to;
    public int lobbyId;
    public Player player;
    public MessageType messageType;
    public Square squareFrom;
    public Square squareTo;
    public PlayingField playingField;
    public String username;
    public ArrayList<Player> players;
    public ArrayList<Piece> pieces;

    public PlayingFieldMessage() {
    }
}
