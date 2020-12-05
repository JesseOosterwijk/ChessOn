package PieceTests;

import chesson.server.logic.pieces.BishopLogic;
import chesson.server.logic.pieces.PieceLogic;
import chesson.server.models.Player;
import chesson.server.models.Square;
import chesson.server.models.pieces.Bishop;
import chesson.server.models.pieces.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BishopLogicTests {
    private PieceLogic pieceLogic;
    private Player player;
    private Square originalSquare;
    private Piece bishop;

    @BeforeEach
    private void SetUp() {
        pieceLogic = new BishopLogic();
        player = new Player("Jesse", 400, new ArrayList<>());
        originalSquare = new Square(5,5);
        bishop = new Bishop(player, originalSquare);
        player.addPiece(bishop);
    }
    @Test
    public void test1() {
        ;
    }
}
