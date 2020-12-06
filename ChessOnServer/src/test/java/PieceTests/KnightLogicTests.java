package PieceTests;

import chesson.server.logic.piecelogic.KnightLogic;
import chesson.server.logic.piecelogic.PieceLogic;
import chesson.server.models.Player;
import chesson.server.models.Square;
import chesson.server.models.pieces.Knight;
import chesson.server.models.pieces.Piece;
import org.junit.Assert;
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
    public void KnightMovingCorrectlyHorizontallyTopRightReturnsNewSquare() {
        Square expected = new Square(6,7);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void KnightMovingCorrectlyHorizontallyBottomRightReturnsNewSquare() {
        Square expected = new Square(4,7);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void KnightMovingCorrectlyHorizontallyTopLeftReturnsNewSquare() {
        Square expected = new Square(6,3);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void KnightMovingCorrectlyHorizontallyBottomLeftReturnsNewSquare() {
        Square expected = new Square(4,3);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void KnightMovingCorrectlyVerticallyTopRightReturnsNewSquare() {
        Square expected = new Square(7,6);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void KnightMovingCorrectlyVerticallyBottomRightReturnsNewSquare() {
        Square expected = new Square(7,6);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void KnightMovingCorrectlyVerticallyTopLeftReturnsNewSquare() {
        Square expected = new Square(3,4);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void KnightMovingCorrectlyVerticallyBottomLeftReturnsNewSquare() {
        Square expected = new Square(3,4);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void KnightMovingIncorrectlyReturnsOriginalSquare() {
        Square to = new Square(5,6);
        Square actual = pieceLogic.MovePiece(originalSquare, to);
        Assert.assertEquals(originalSquare, actual);
    }

    @Test
    public void KnightMovingIncorrectly2ReturnsOriginalSquare() {
        Square to = new Square(6,5);
        Square actual = pieceLogic.MovePiece(originalSquare, to);
        Assert.assertEquals(originalSquare, actual);
    }

    @Test
    public void KnightMovingOutOfBoundsRankReturnsOriginalSquare() {
        Square origin = new Square(8,5);
        Square expected = new Square(10,6);
        Square actual = pieceLogic.MovePiece(origin, expected);
        Assert.assertEquals(origin, actual);
    }

    @Test
    public void KnightMovingOutOfBoundsFileReturnsOriginalSquare() {
        Square origin = new Square(5,8);
        Square expected = new Square(4,10);
        Square actual = pieceLogic.MovePiece(origin, expected);
        Assert.assertEquals(origin, actual);
    }

//TODO
//    @Test
//    public void KnightMovingDiscoversCheckReturnsOriginalSquare() {
//        Square expected = new Square(5,7);
//        Square actual = pieceLogic.MovePiece(originalSquare, expected);
//        Assert.assertEquals(expected, actual);
//    }
//    @Test
//    public void KnightMovingStillInCheckReturnsOriginalSquare() {
//        Square expected = new Square(5,7);
//        Square actual = pieceLogic.MovePiece(originalSquare, expected);
//        Assert.assertEquals(expected, actual);
//    }
}
