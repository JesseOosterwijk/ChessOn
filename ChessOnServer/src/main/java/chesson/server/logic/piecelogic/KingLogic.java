package chesson.server.logic.piecelogic;

import chesson.server.models.Square;

public class KingLogic implements PieceLogic {
    @Override
    public Square MovePiece(Square from, Square to) {
        if(CanMovePiece(from, to)) {
            return to;
        } else {
            return from;
        }
    }

    private boolean CanMovePiece(Square from, Square to) {
        return MovesCorrectly(from, to) && !IsInCheckAfterMove(from, to) && !MovesOutOfBounds(to);
    }

    //TODO
    private boolean IsInCheckAfterMove(Square from, Square to) {
        return false;
    }

    private boolean MovesCorrectly(Square from, Square to) {
        return !MovesMoreThanOneSquare(from, to);
    }

    private boolean MovesMoreThanOneSquare(Square from, Square to) {
        return Math.abs(from.getRank() - to.getRank()) > 1 || Math.abs(from.getFile() - to.getFile()) > 1;
    }

    private boolean MovesOutOfBounds(Square to) {
        return to.getFile() > 8 || to.getRank() > 8;
    }
}