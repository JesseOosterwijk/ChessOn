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
        return MovesNormally(from, to) && !IsInCheckAfterMove(from, to) && !MovesOverOtherPieces(from, to);
    }

    //TODO
    private boolean IsInCheckAfterMove(Square from, Square to) {
        return true;
    }

    private boolean MovesNormally(Square from, Square to) {
        return Math.abs(from.getRank() - to.getRank()) == Math.abs(from.getFile() - to.getFile());
    }

    //TODO
    private boolean MovesOverOtherPieces(Square from, Square to) {
        return false;
    }
}
