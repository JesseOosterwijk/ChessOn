package chesson.server.logic.piecelogic;

import chesson.server.models.Square;

import java.util.ArrayList;

public class QueenLogic implements PieceLogic {
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
        if(MovesCorrectlyHorizontally(from, to)) {
            for(Square square: getSquaresHorizontally(from, to)) {
                squares.add(square);
            }
        } else if(MovesCorrectlyVertically(from, to)) {
            for(Square square: getSquaresVertically(from, to)) {
                squares.add(square);
            }
        } else if(MovesCorrectlyDiagonally(from, to)) {
            for(Square square: getSquaresDiagonally(from, to)) {
                squares.add(square);
            }
        }
        return squares;
    }

    static ArrayList<Square> getSquaresDiagonally(Square from, Square to) {
        if(from.getRank() < to.getRank() && from.getFile() < to.getFile()) {
            return getSquaresDiagonallyTopRight(from, to);
        } else if(from.getRank() < to.getRank() && from.getFile() > to.getFile()) {
            return getSquaresDiagonallyBottomRight(from, to);
        } else if(from.getRank() > to.getRank() && from.getFile() > to.getFile()) {
            return getSquaresDiagonallyBottomLeft(from, to);
        } else if(from.getRank() > to.getRank() && from.getFile() < to.getFile()) {
            return getSquaresDiagonallyTopLeft(from, to);
        } else {
            return null;
        }
    }

    static ArrayList<Square> getSquaresHorizontally(Square from, Square to) {
        if(from.getRank() > to.getRank()) {
            return getSquaresHorizontallyNegative(from, to);
        } else if (from.getRank() < to.getRank()){
            return getSquaresHorizontallyPositive(from, to);
        } else {
            return null;
        }
    }

    static ArrayList<Square> getSquaresVertically(Square from, Square to) {
        if(from.getFile() > to.getFile()) {
            return getSquaresVerticallyNegative(from, to);
        } else if (from.getFile() < to.getFile()){
            return getSquaresVerticallyPositive(from, to);
        } else {
            return null;
        }
    }

    static ArrayList<Square> getSquaresDiagonallyTopRight(Square from, Square to) {
        ArrayList<Square> squares = new ArrayList<>();
        int amountOfSquares = Math.abs(from.getFile() - to.getFile());
        for(int i = 1; i < amountOfSquares; i++) {
            Square square = new Square(from.getRank() + i, from.getFile() + i);
            squares.add(square);
        }
        return squares;
    }

    static ArrayList<Square> getSquaresDiagonallyTopLeft(Square from, Square to) {
        ArrayList<Square> squares = new ArrayList<>();
        int amountOfSquares = Math.abs(from.getFile() - to.getFile());
        for(int i = 1; i < amountOfSquares; i++) {
            Square square = new Square(from.getRank() - i, from.getFile() + i);
            squares.add(square);
        }
        return squares;
    }

    static ArrayList<Square> getSquaresDiagonallyBottomRight(Square from, Square to) {
        ArrayList<Square> squares = new ArrayList<>();
        int amountOfSquares = Math.abs(from.getFile() - to.getFile());
        for(int i = 1; i < amountOfSquares; i++) {
            Square square = new Square(from.getRank() + i, from.getFile() - i);
            squares.add(square);
        }
        return squares;
    }

    static ArrayList<Square> getSquaresDiagonallyBottomLeft(Square from, Square to) {
        ArrayList<Square> squares = new ArrayList<>();
        int amountOfSquares = Math.abs(from.getFile() - to.getFile());
        for(int i = 1; i < amountOfSquares; i++) {
            Square square = new Square(from.getRank() - i, from.getFile() - i);
            squares.add(square);
        }
        return squares;
    }

    static ArrayList<Square> getSquaresVerticallyPositive(Square from, Square to) {
        ArrayList<Square> squares = new ArrayList<>();
        int amountOfSquares = Math.abs(from.getFile() - to.getFile());
        for(int i = 1; i < amountOfSquares; i++) {
            Square square = new Square(from.getFile() + i, from.getRank());
            squares.add(square);
        }
        return squares;
    }

    static ArrayList<Square> getSquaresVerticallyNegative(Square from, Square to) {
        ArrayList<Square> squares = new ArrayList<>();
        int amountOfSquares = Math.abs(from.getFile() - to.getFile());
        for(int i = 1; i < amountOfSquares; i++) {
            Square square = new Square(from.getRank(), from.getFile() - i);
            squares.add(square);
        }
        return squares;
    }

    static ArrayList<Square> getSquaresHorizontallyPositive(Square from, Square to) {
        ArrayList<Square> squares = new ArrayList<>();
        int amountOfSquares = Math.abs(from.getRank() - to.getRank());
        for(int i = 1; i < amountOfSquares; i++) {
            Square square = new Square(from.getRank() + i, from.getFile());
            squares.add(square);
        }
        return squares;
    }

    static ArrayList<Square> getSquaresHorizontallyNegative(Square from, Square to) {
        ArrayList<Square> squares = new ArrayList<>();
        int amountOfSquares = Math.abs(from.getRank() - to.getRank());
        for(int i = 1; i < amountOfSquares; i++) {
            Square square = new Square(from.getRank() - i, from.getFile());
            squares.add(square);
        }
        return squares;
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
        return from.getRank() == to.getRank();
    }

    private boolean MovesCorrectlyHorizontally(Square from, Square to) {
        return from.getFile() == to.getFile();
    }

    private boolean MovesOutOfBounds(Square to) {
        return to.getFile() > 8 || to.getRank() > 8;
    }
}
