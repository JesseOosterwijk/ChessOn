package chesson.server.logic.pieces;

import chesson.server.models.Piece;
import chesson.server.models.Square;

public class RookLogic implements PieceLogic {
    @Override
    public Square MovePiece(Square from, Square to) {
        return to;
    }

    private boolean CanMovePiece(Square from, Square to) {
        return MovesNormally(from, to) && !IsInCheckAfterMove(from, to) && !MovesOverOtherPieces(from, to);
    }

    //TODO
    private boolean IsInCheckAfterMove(Square from, Square to) {
        return true;
    }

    private boolean MovesNormally(Square from, Square to) {
        if(from.getRank() == to.getRank()) {
            return MovesCorrectlyVertically(from, to);
        } else if (from.getFile() == to.getFile()) {
            return MovesCorrectlyHorizontally(from, to);
        } else {
            return false;
        }
    }

    private boolean MovesCorrectlyVertically(Square from, Square to) {
        return from.getFile() == to.getFile();
    }

    private boolean MovesCorrectlyHorizontally(Square from, Square to) {
        return from.getRank() == to.getRank();
    }

    //TODO
    private boolean MovesOverOtherPieces(Square from, Square to) {
        return false;
    }
}
