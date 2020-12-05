package chesson.server.logic.pieces;

import chesson.server.models.Piece;
import chesson.server.models.Square;

public class RookLogic implements PieceLogic {
    @Override
    public Square MovePiece(Square from, Square to) {
        return to;
    }

    private boolean CanMovePiece(Square from, Square to) {
        return false;
    }

    //TODO
    private boolean IsInCheckAfterMove(Square from, Square to) {
        return true;
    }

    private boolean MovesNormally(Square from, Square to) {

        return true;
    }

    private boolean MovesCorrectlyVertical() {
        return true;
    }

    private boolean MovesCorrectlyHorizontal(Square from, Square to) {
        return true;
    }

    //TODO
    private boolean MovesOverOtherPieces(Square from, Square to) {
        return false;
    }
}
