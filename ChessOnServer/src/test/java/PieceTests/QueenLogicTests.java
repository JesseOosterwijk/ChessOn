package PieceTests;

import chesson.server.logic.pieces.PieceLogic;
import chesson.server.logic.pieces.QueenLogic;
import chesson.server.models.Player;
import chesson.server.models.Square;
import chesson.server.models.pieces.Piece;
import chesson.server.models.pieces.Queen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class QueenLogicTests {
    private PieceLogic pieceLogic;
    private Player player;
    private Square originalSquare;
    private Piece queen;

    @BeforeEach
    private void SetUp() {
        pieceLogic = new QueenLogic();
        player = new Player("Jesse", 400, new ArrayList<>());
        originalSquare = new Square(5,5);
        queen = new Queen(player, originalSquare);
        player.addPiece(queen);
    }

    @Test
    public void test1() {
        ;
    }
}
