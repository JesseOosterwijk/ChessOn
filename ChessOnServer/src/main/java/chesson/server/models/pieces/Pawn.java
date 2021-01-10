package chesson.server.models.pieces;

import chesson.server.logic.piecelogic.PawnLogic;
import chesson.server.models.Player;
import chesson.server.models.Square;

public class Pawn extends Piece {

    public Pawn(Square square, Player player, String url) {
        super(square, player, 1, url, new PawnLogic());
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
