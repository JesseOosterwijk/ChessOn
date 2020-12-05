package chesson.server.logic.pieces;

import chesson.server.models.Square;

public class BishopLogic implements PieceLogic {

    @Override
    public Square MovePiece(Square from, Square to) {
        return to;
    }

    public boolean CanMovePiece(Square from, Square to) {
        return false;
    }

    public boolean TryMovePiece(Square from, Square to) {
        return false;
    }

    public boolean IsAllowedToMoveThere(Square from, Square to) {
        return false;
    }

    public boolean IsInCheckAfterMove(Square from, Square to) {
        return true;
    }
}
