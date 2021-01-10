package chesson.server.models.pieces;

import chesson.server.logic.piecelogic.KnightLogic;
import chesson.server.models.Player;
import chesson.server.models.Square;

public class Knight extends Piece {

    public Knight(Square square, Player player, String url) {
        super(square, player, 3, url, new KnightLogic());
    }

    @Override
    public boolean tryMoveSquare(Square from, Square to) {
        return pieceLogic.CanMovePiece(from, to);
    }

    @Override
    public void move(Square from, Square to) {
        pieceLogic.MovePiece(from, to);
    }
}
