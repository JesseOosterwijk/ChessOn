package chesson.server.models.pieces;

import chesson.server.logic.piecelogic.BishopLogic;
import chesson.server.models.Player;
import chesson.server.models.Square;

public class Bishop extends Piece {

    public Bishop(Square square, String url) {
        super(square, 3, url, new BishopLogic());
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
