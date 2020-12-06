package chesson.server.logic.piecelogic;

import chesson.server.models.Square;

public class RookLogic implements PieceLogic {
    @Override
    public Square MovePiece(Square from, Square to) {
        if(CanMovePiece(from, to)) {
            return to;
        } else {
            return from;
        }
    }

    private boolean CanMovePiece(Square from, Square to) {
        return MovesNormally(from, to) && !IsInCheckAfterMove(from, to) && !MovesOverOtherPieces(from, to) && !MovesOutOfBounds(to);
    }

    //TODO
    private boolean IsInCheckAfterMove(Square from, Square to) {
        return false;
    }

    private boolean MovesNormally(Square from, Square to) {
        if(MovesCorrectlyHorizontally(from, to) || MovesCorrectlyVertically(from, to)) {
            return true;
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

    private boolean MovesOutOfBounds(Square to) {
        return to.getFile() > 8 || to.getRank() > 8;
    }
}
