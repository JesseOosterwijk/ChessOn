package chesson.server.logic.pieces;

import chesson.server.models.Piece;
import chesson.server.models.Square;

public class KnightLogic implements PieceLogic {
    @Override
    public void MovePiece(Piece piece, Square from, Square to) {

    }

    public boolean CanMovePiece(Piece piece, Square from, Square to) {
        return false;
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
}
