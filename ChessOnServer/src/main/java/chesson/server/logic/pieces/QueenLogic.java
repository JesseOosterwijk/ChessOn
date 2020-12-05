package chesson.server.logic.pieces;

import chesson.server.models.Square;

public class QueenLogic implements PieceLogic {
    @Override
    public Square MovePiece(Square from, Square to) {
        return to;
    }

    private boolean CanMovePiece(Square from, Square to) {
        return false;
    }

    private boolean TryMovePiece(Square from, Square to) {
        return false;
    }

    private boolean IsAllowedToMoveThere(Square from, Square to) {
        return false;
    }

    //TODO
    private boolean IsInCheckAfterMove(Square from, Square to) {
        return true;
    }

    private boolean TriesToMoveIllegally(Square from, Square to) {
        return true;
    }
}
