package PieceTests;

import chesson.server.logic.pieces.KnightLogic;
import chesson.server.logic.pieces.PieceLogic;
import chesson.server.models.Player;
import chesson.server.models.Square;
import chesson.server.models.pieces.Knight;
import chesson.server.models.pieces.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class KnightLogicTests {
    private PieceLogic pieceLogic;
    private Player player;
    private Square originalSquare;
    private Piece knight;

    @BeforeEach
    private void SetUp() {
        pieceLogic = new KnightLogic();
        player = new Player("Jesse", 400, new ArrayList<>());
        originalSquare = new Square(5,5);
        knight = new Knight(player, originalSquare);
        player.addPiece(knight);
    }
    @Test
    public void test1() {
        ;
    }
}
