package PieceTests;

import chesson.server.logic.pieces.KingLogic;
import chesson.server.logic.pieces.PieceLogic;
import chesson.server.models.Player;
import chesson.server.models.Square;
import chesson.server.models.pieces.King;
import chesson.server.models.pieces.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class KingLogicTests {
    private PieceLogic pieceLogic;
    private Player player;
    private Square originalSquare;
    private Piece king;

    @BeforeEach
    private void SetUp() {
        pieceLogic = new KingLogic();
        player = new Player("Jesse", 400, new ArrayList<>());
        originalSquare = new Square(5,5);
        king = new King(player, originalSquare);
        player.addPiece(king);
    }
    @Test
    public void test1() {
        ;
    }
}
