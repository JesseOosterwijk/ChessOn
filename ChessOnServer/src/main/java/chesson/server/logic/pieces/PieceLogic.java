package chesson.server.logic.pieces;

import chesson.server.models.Piece;
import chesson.server.models.Square;
import org.springframework.stereotype.Component;

@Component
public interface PieceLogic {
    void MovePiece(Piece piece, Square from, Square to);
}
