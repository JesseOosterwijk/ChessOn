package chesson.server.logic;

import chesson.server.models.Piece;
import chesson.server.models.Square;

public class PieceLogic {

    public void MovePiece(Piece piece, Square from, Square to) {

    }

    public void TryMovePiece(Piece piece, Square from, Square to) {
        if(CanMovePiece(piece, from, to)) {
            MovePiece(piece, from, to);
        } else {
            ;
        }
    }

    public void RemovePiece(Piece piece) {

    }

    public boolean CanMovePiece(Piece piece, Square from, Square to) {
        if(IsAllowedToMoveThere(piece, from, to) && !IsInCheckAfterMove(piece, from, to)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean IsAllowedToMoveThere(Piece piece, Square from, Square to) {
        return true;
    }

    public boolean IsInCheckAfterMove(Piece piece, Square from, Square to) {
        return true;
    }
}
