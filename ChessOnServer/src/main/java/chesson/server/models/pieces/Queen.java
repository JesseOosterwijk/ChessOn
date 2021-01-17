package chesson.server.models.pieces;

import chesson.server.logic.piecelogic.QueenLogic;
import chesson.server.models.Player;
import chesson.server.models.Square;

public class Queen extends Piece {

    public Queen(Square square, String url) {
        super(square, 9, url, new QueenLogic());
    }

    @Override
    public boolean tryMoveSquare(Square from, Square to) {
        return pieceLogic.CanMovePiece(from, to);
    }

    @Override
    public void move(Square from, Square to) {
        pieceLogic.MovePiece(from, to);
    }
}
