package chesson.server.logic.pieces;

import chesson.server.models.Piece;
import chesson.server.models.Square;

public class BishopLogic implements PieceLogic {

    @Override
    public void MovePiece(Piece piece, Square from, Square to) {

    }

    @Override
    public boolean CanMovePiece(Piece piece, Square from, Square to) {
        return false;
    }

    @Override
    public boolean TryMovePiece(Piece piece, Square from, Square to) {
        return false;
    }

    @Override
    public boolean IsAllowedToMoveThere(Piece piece, Square from, Square to) {
        return false;
    }

    @Override
    public boolean IsInCheckAfterMove(Piece piece, Square from, Square to) {
        return true;
    }
}
