package chesson.server.logic.piecelogic;

import chesson.server.models.Square;

public class QueenLogic implements PieceLogic {
    @Override
    public Square MovePiece(Square from, Square to) {
        if(CanMovePiece(from, to)) {
            return to;
        } else {
            return from;
        }
    }

    private boolean CanMovePiece(Square from, Square to) {
        return MovesCorrectly(from, to) && !IsInCheckAfterMove(from, to) && !MovesOverOtherPieces(from, to) && !MovesOutOfBounds(to);
    }

    //TODO
    private boolean IsInCheckAfterMove(Square from, Square to) {
        return false;
    }

    private boolean MovesCorrectly(Square from, Square to) {
        return MovesCorrectlyDiagonally(from, to) || MovesCorrectlyOrthogonallyAdjacent(from, to);
    }

    private boolean MovesCorrectlyDiagonally(Square from, Square to) {
        return Math.abs(from.getRank() - to.getRank()) == Math.abs(from.getFile() - to.getFile());
    }

    private boolean MovesCorrectlyOrthogonallyAdjacent(Square from, Square to) {
        return MovesCorrectlyHorizontally(from, to) || MovesCorrectlyVertically(from, to);
    }

    private boolean MovesCorrectlyVertically(Square from, Square to) {
        return from.getFile() == to.getFile();
    }

    private boolean MovesCorrectlyHorizontally(Square from, Square to) {
        return from.getRank() == to.getRank();
    }

    //TODO
    private boolean MovesOverOtherPieces(Square from, Square to) {
        return false;
    }

    private boolean MovesOutOfBounds(Square to) {
        return to.getFile() > 8 || to.getRank() > 8;
    }
}
