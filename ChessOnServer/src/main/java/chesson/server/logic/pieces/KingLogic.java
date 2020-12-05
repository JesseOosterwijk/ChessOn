package chesson.server.logic.pieces;

import chesson.server.models.Square;

public class KingLogic implements PieceLogic {
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

    private boolean MovesCorrectly(Square from, Square to) {
        return false;
    }
}
