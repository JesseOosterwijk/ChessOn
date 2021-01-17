package chesson.server.models.pieces;

import chesson.server.logic.piecelogic.PieceLogic;
import chesson.server.models.Player;
import chesson.server.models.Square;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
public abstract class Piece {
    @Getter @Setter
    Square square;
    @Getter
    int value = 0;
    @Getter
    String url = null;
    PieceLogic pieceLogic;

    public boolean tryMoveSquare(Square from, Square to) {
        return pieceLogic.CanMovePiece(from, to);
    }

    public void move(Square from, Square to) {
        pieceLogic.MovePiece(from, to);
    }

    public ArrayList<Square> getSquaresInBetweenMove(Square from, Square to) {
        return pieceLogic.getSquaresInBetweenMove(from, to);
    }
}
