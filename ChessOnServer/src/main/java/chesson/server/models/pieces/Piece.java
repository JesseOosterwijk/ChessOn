package chesson.server.models.pieces;

import chesson.server.models.Player;
import chesson.server.models.Square;

public abstract class Piece {
    private Square square;
    private Player player;

    public Piece(Player player, Square square) {
        this.player = player;
        this.square = square;
    }

    public Square getSquare() {
        return square;
    }

    public Player getPlayer() {
        return player;
    }
}
