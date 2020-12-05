package chesson.server.models;

import chesson.server.models.pieces.Piece;

import java.util.List;

public class PlayingField {
    private List<Square> squares;
    private List<Piece> pieces;

    public List<Square> getSquares() {
        return squares;
    }

    public void setSquares(List<Square> squares) {
        this.squares = squares;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
    }
}
