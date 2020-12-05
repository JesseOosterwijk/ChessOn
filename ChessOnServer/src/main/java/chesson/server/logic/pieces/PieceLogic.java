package chesson.server.logic.pieces;

import chesson.server.models.Piece;
import chesson.server.models.Square;
import org.springframework.stereotype.Component;

@Component
public interface PieceLogic {
    public void MovePiece(Piece piece, Square from, Square to);
    public boolean CanMovePiece(Piece piece, Square from, Square to);
    public boolean TryMovePiece(Piece piece, Square from, Square to);
    public boolean IsAllowedToMoveThere(Piece piece, Square from, Square to);
    public boolean IsInCheckAfterMove(Piece piece, Square from, Square to);
}
