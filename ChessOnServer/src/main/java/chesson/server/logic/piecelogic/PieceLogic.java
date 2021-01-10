package chesson.server.logic.piecelogic;

import chesson.server.models.Square;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface PieceLogic {
    boolean CanMovePiece(Square from, Square to);
    Square MovePiece(Square from, Square to);
    ArrayList<Square> getSquaresInBetweenMove(Square from, Square to);
}
