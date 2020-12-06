package PieceTests;

import chesson.server.logic.piecelogic.PieceLogic;
import chesson.server.logic.piecelogic.RookLogic;
import chesson.server.models.Player;
import chesson.server.models.Square;
import chesson.server.models.pieces.Piece;
import chesson.server.models.pieces.Rook;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class RookLogicTests {

    private PieceLogic pieceLogic;
    private Player player;
    private Square originalSquare;
    private Piece rook;

    @BeforeEach
    private void SetUp() {
        pieceLogic = new RookLogic();
        player = new Player("Jesse", 400, new ArrayList<>());
        originalSquare = new Square(5,5);
        rook = new Rook(player, originalSquare);
        player.addPiece(rook);
    }

    @AfterEach
    void tearDown() {
        ;
    }

    @Test
    public void RookMovingIllegallyReturnsOriginalSquare() {
        Square expected = originalSquare;
        Square result = pieceLogic.MovePiece(originalSquare, new Square(4,4));
        Assert.assertEquals(expected, result);
    }

    @Test
    public void RookMovingHorizontallyPositiveReturnsNewSquare() {
        Square expected = new Square(5,8);
        Square result = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void RookMovingHorizontallyNegativeReturnsNewSquare() {
        Square expected = new Square(5,2);
        Square result = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void RookMovingVerticallyPositiveReturnsNewSquare() {
        Square expected = new Square(8,5);
        Square result = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void RookMovingVerticallyNegativeReturnsNewSquare() {
        Square expected = new Square(2,5);
        Square result = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void RookMovingOutOfBoundsFileReturnsOriginalSquare() {
        Square to = new Square(1,9);
        Square result = pieceLogic.MovePiece(originalSquare, to);
        Assert.assertEquals(originalSquare, result);
    }

    @Test
    public void RookMovingOutOfBoundsRankReturnsOriginalSquare() {
        Square to = new Square(9,1);
        Square result = pieceLogic.MovePiece(originalSquare, to);
        Assert.assertEquals(originalSquare, result);
    }
}
