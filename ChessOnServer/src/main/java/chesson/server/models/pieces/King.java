package chesson.server.models.pieces;

import chesson.server.logic.piecelogic.KingLogic;
import chesson.server.models.Player;
import chesson.server.models.Square;

public class King extends Piece {

    public King(Square square, String url) {
        super(square,0, url, new KingLogic());
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
