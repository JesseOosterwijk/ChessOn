package chesson.server.logic.pieces;

import chesson.server.models.Square;
import org.springframework.stereotype.Component;

@Component
public interface PieceLogic {
    Square MovePiece(Square from, Square to);
}
