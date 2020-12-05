package chesson.server.logic.pieces;

import chesson.server.models.Square;

public class PawnLogic implements PieceLogic {
    @Override
    public Square MovePiece(Square from, Square to) {
        if(CanMovePiece(from, to)) {
            return to;
        } else {
            return from;
        }
    }

    private boolean CanMovePiece(Square from, Square to) {
        return !TriesToMoveIllegally(from, to) && !IsInCheckAfterMove(from, to) && !MovesOverOtherPieces(from, to);
    }

    //TODO
    private boolean IsInCheckAfterMove(Square from, Square to) {
        return true;
    }

    private boolean TriesToMoveIllegally(Square from, Square to) {
        return TriesToMoveDiagonally(from, to) || TriesToMoveMoreThanOneSquareForwards(from, to) || TriesToMoveBackwards(from, to);
    }

    private boolean TriesToMoveBackwards(Square from, Square to) {
        if(from.getRank() > to.getRank()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean TriesToMoveMoreThanOneSquareForwards(Square from, Square to) {
        if(to.getRank() - from.getRank() > 1) {
            return true;
        } else {
            return to.getRank() - from.getRank() == 1 && from.getRank() != 2;
        }
    }

    private boolean TriesToMoveDiagonally(Square from, Square to) {
        return from.getFile() != to.getFile();
    }

    //TODO
    private boolean MovesOverOtherPieces(Square from, Square to) {
        return false;
    }

}
