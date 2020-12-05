package chesson.server.logic.pieces;

import chesson.server.models.Square;

public class BishopLogic implements PieceLogic {

    @Override
    public Square MovePiece(Square from, Square to) {
        if(CanMovePiece(from, to)) {
            return to;
        } else {
            return from;
        }
    }

    private boolean CanMovePiece(Square from, Square to) {
        if(MovesNormally(from, to) && !IsInCheckAfterMove(from, to) && !MovesOverOtherPieces(from, to)) {
            return true;
        } else {
            return false;
        }
    }

    //TODO
    private boolean IsInCheckAfterMove(Square from, Square to) {
        return true;
    }

    private boolean MovesNormally(Square from, Square to) {
        if(Math.abs(from.getRank() - to.getRank()) == Math.abs(from.getFile() - to.getFile())) {
            return true;
        } else {
            return false;
        }
    }

    //TODO
    private boolean MovesOverOtherPieces(Square from, Square to) {
        return false;
    }
}
