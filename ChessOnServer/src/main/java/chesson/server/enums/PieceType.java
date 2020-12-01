package chesson.server.enums;

public enum PieceType {
    King(1),
    Queen(9),
    Rook(5),
    Bishop(3),
    Knight(3),
    Pawn(1);

    public final int value;

    PieceType(int value) {
        this.value = value;
    }
}
