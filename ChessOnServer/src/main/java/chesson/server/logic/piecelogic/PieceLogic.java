package chesson.server.logic.piecelogic;

import chesson.server.models.Square;
import org.springframework.stereotype.Component;

@Component
public interface PieceLogic {
    Square MovePiece(Square from, Square to);
}
