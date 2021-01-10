package chesson.server.logic.piecelogic;

import chesson.server.models.Square;

import java.util.ArrayList;

import static chesson.server.logic.piecelogic.QueenLogic.getSquaresHorizontally;
import static chesson.server.logic.piecelogic.QueenLogic.getSquaresVertically;

public class RookLogic implements PieceLogic {
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
        return MovesNormally(from, to) && !MovesOutOfBounds(to);
    }

    @Override
    public ArrayList<Square> getSquaresInBetweenMove(Square from, Square to) {
        ArrayList<Square> squares = new ArrayList<>();
        if(MovesCorrectlyHorizontally(from, to)) {
            for(Square square: getSquaresHor(from, to)) {
                squares.add(square);
            }
        } else if(MovesCorrectlyVertically(from, to)) {
            for(Square square: getSquaresVer(from, to)) {
                squares.add(square);
            }
        }
        return squares;
    }

    private ArrayList<Square> getSquaresVer(Square from, Square to) {
        return getSquaresVertically(from, to);
    }

    private ArrayList<Square> getSquaresHor(Square from, Square to) {
        return getSquaresHorizontally(from, to);
    }

    private boolean MovesNormally(Square from, Square to) {
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
