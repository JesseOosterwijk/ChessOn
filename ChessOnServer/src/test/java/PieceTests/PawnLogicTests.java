package PieceTests;

import chesson.server.logic.pieces.PawnLogic;
import chesson.server.logic.pieces.PieceLogic;
import chesson.server.models.Player;
import chesson.server.models.Square;
import chesson.server.models.pieces.Pawn;
import chesson.server.models.pieces.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PawnLogicTests {
    private PieceLogic pieceLogic;
    private Player player;
    private Square originalSquare;
    private Piece pawn;

    @BeforeEach
    private void SetUp() {
        pieceLogic = new PawnLogic();
        player = new Player("Jesse", 400, new ArrayList<>());
        originalSquare = new Square(5,5);
        pawn = new Pawn(player, originalSquare);
        player.addPiece(pawn);
    }

    @Test
    public void test() {

    }
}
