package chesson.server.logic.pieces;

import chesson.server.models.Piece;
import chesson.server.models.Square;

public class PawnLogic implements PieceLogic {
    @Override
    public void MovePiece(Piece piece, Square from, Square to) {

    }

    public boolean CanMovePiece(Piece piece, Square from, Square to) {
        if(!TriesToMoveIllegally(from, to)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean TryMovePiece(Piece piece, Square from, Square to) {
        return false;
    }

    public boolean IsAllowedToMoveThere(Piece piece, Square from, Square to) {
        return false;
    }

    public boolean IsInCheckAfterMove(Piece piece, Square from, Square to) {
        return true;
    }

    public boolean TriesToMoveIllegally(Square from, Square to) {
        if(TriesToMoveDiagonally(from, to) || TriesToMoveMoreThanOneSquareForwards(from, to) || TriesToMoveBackwards(from, to)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean TriesToMoveBackwards(Square from, Square to) {
        if(from.getRank() > to.getRank()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean TriesToMoveMoreThanOneSquareForwards(Square from, Square to) {
        if(to.getRank() - from.getRank() > 1) {
            return true;
        } else if(to.getRank() - from.getRank() == 1 && from.getRank() != 2) {
            return true;
        } else {
            return false;
        }
    }

    public boolean TriesToMoveDiagonally(Square from, Square to) {
        if(from.getFile() != to.getFile()) {
            return true;
        } else {
            return false;
        }
    }

}
