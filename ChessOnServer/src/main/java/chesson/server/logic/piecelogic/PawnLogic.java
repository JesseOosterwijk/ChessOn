package chesson.server.logic.piecelogic;

import chesson.server.models.Square;

import java.util.ArrayList;

public class PawnLogic implements PieceLogic {
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
        int amountOfSquares = to.getRank() - from.getRank();
        for(int i = 0; i < amountOfSquares; i++) {
            Square square = new Square(from.getRank() + i + 1, from.getFile());
            squares.add(square);
        }
        return squares;
    }

    private boolean MovesCorrectly(Square from, Square to) {
        return !TriesToMoveDiagonally(from, to) && !TriesToMoveMoreThanOneSquareForwards(from, to) && !TriesToMoveBackwards(from, to);
    }

    private boolean TriesToMoveBackwards(Square from, Square to) {
//        return from.getRank() > to.getRank();
        return false;
    }

    private boolean TriesToMoveMoreThanOneSquareForwards(Square from, Square to) {
        if(from.getFile() == 1 || from.getFile() == 6) {
            return Math.abs(to.getFile() - from.getFile()) > 2;
        } else {
            return !(to.getFile() - from.getFile() == 1);
        }
    }

    private boolean TriesToMoveDiagonally(Square from, Square to) {
        return from.getRank() != to.getRank();
    }

    private boolean MovesOutOfBounds(Square to) {
        return to.getFile() > 8 || to.getRank() > 8;
    }


}
