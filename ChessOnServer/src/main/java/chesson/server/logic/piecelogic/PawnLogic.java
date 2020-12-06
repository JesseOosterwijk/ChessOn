package chesson.server.logic.piecelogic;

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
        return MovesCorrectly(from, to) && !IsInCheckAfterMove(from, to) && !MovesOverOtherPieces(from, to) && !MovesOutOfBounds(to);
    }

    //TODO
    private boolean IsInCheckAfterMove(Square from, Square to) {
        return false;
    }

    private boolean MovesCorrectly(Square from, Square to) {
        return !TriesToMoveDiagonally(from, to) || TriesToMoveMoreThanOneSquareForwards(from, to) || !TriesToMoveBackwards(from, to);
    }

    private boolean TriesToMoveBackwards(Square from, Square to) {
        return from.getRank() > to.getRank();
    }

    private boolean TriesToMoveMoreThanOneSquareForwards(Square from, Square to) {
        if(from.getRank() == 2 && to.getRank() - from.getRank() < 3) {
            return false;
        } else {
            return !(to.getRank() - from.getRank() == 1);
        }
    }

    private boolean TriesToMoveDiagonally(Square from, Square to) {
        return from.getFile() != to.getFile();
    }

    //TODO
    private boolean MovesOverOtherPieces(Square from, Square to) {
        return false;
    }

    private boolean MovesOutOfBounds(Square to) {
        return to.getFile() > 8 || to.getRank() > 8;
    }

}
