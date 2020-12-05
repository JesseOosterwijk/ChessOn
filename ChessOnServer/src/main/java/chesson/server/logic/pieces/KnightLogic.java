package chesson.server.logic.pieces;

import chesson.server.models.Square;

public class KnightLogic implements PieceLogic {
    @Override
    public Square MovePiece(Square from, Square to) {
        if(CanMovePiece(from, to)) {
            return to;
        } else {
            return from;
        }
    }

    public boolean CanMovePiece(Square from, Square to) {
        if(MovesNormally(from, to) && !IsInCheckAfterMove()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean IsInCheckAfterMove() {
        return true;
    }

    public boolean MovesNormally(Square from, Square to) {
        if(CorrectHorizontalJump(from, to) || CorrectVerticalJump(from, to)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean CorrectHorizontalJump(Square from, Square to) {
        if(from.getRank() - to.getRank() == 1 || to.getRank() - from.getRank() == 1) {
            if(from.getFile() - to.getFile() == 2 || to.getFile() - from.getFile() == 2) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean CorrectVerticalJump(Square from, Square to) {
        if(from.getFile() - to.getFile() == 1 || to.getFile() - from.getFile() == 1) {
            if(from.getRank() - to.getRank() == 2 || to.getRank() - from.getRank() == 2) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
