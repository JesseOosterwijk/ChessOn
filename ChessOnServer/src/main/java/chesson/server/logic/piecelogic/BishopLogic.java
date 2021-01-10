package chesson.server.logic.piecelogic;

import chesson.server.models.Square;

import java.util.ArrayList;

import static chesson.server.logic.piecelogic.QueenLogic.getSquaresDiagonally;

public class BishopLogic implements PieceLogic {

    @Override
    public Square MovePiece(Square from, Square to) {
        if(CanMovePiece(from, to)) {
            return to;
        } else {
            return from;
        }
    }

    @Override
    public boolean CanMovePiece(Square from, Square to) {
        return MovesCorrectly(from, to) && !MovesOutOfBounds(to);
    }

    @Override
    public ArrayList<Square> getSquaresInBetweenMove(Square from, Square to) {
        ArrayList<Square> squares = new ArrayList<>();
        for(Square square: getSquaresDiag(from, to)) {
            squares.add(square);
        }
        return squares;
    }

    private ArrayList<Square> getSquaresDiag(Square from, Square to) {
        return getSquaresDiagonally(from, to);
    }

    private boolean MovesCorrectly(Square from, Square to) {
        return Math.abs(from.getRank() - to.getRank()) == Math.abs(from.getFile() - to.getFile());
    }

    private boolean MovesOutOfBounds(Square to) {
        return to.getFile() > 8 || to.getRank() > 8;
    }


}
