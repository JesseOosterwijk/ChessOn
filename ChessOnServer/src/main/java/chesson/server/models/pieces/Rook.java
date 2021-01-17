package chesson.server.models.pieces;

import chesson.server.logic.piecelogic.RookLogic;
import chesson.server.models.Square;

public class Rook extends Piece {

    public Rook(Square square, String url) {
        super(square, 5, url, new RookLogic());
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
