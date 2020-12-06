package PieceTests;

import chesson.server.logic.piecelogic.PieceLogic;
import chesson.server.logic.piecelogic.QueenLogic;
import chesson.server.models.Player;
import chesson.server.models.Square;
import chesson.server.models.pieces.Piece;
import chesson.server.models.pieces.Queen;
import org.junit.Assert;
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
    public void QueenMovingHorizontallyPositiveReturnsNewSquare() {
        Square expected = new Square(5,7);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void QueenMovingHorizontallyNegativeReturnsNewSquare() {
        Square expected = new Square(5,2);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void QueenMovingVerticallyPositiveReturnsNewSquare() {
        Square expected = new Square(7,5);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void QueenMovingVerticallyNegativeReturnsNewSquare() {
        Square expected = new Square(2,5);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void QueenMovingDiagonallyTopRightReturnsNewSquare() {
        Square expected = new Square(8,8);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void QueenMovingDiagonallyTopLeftReturnsNewSquare() {
        Square expected = new Square(8,2);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void QueenMovingDiagonallyBottomRightReturnsNewSquare() {
        Square expected = new Square(3,7);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void QueenMovingDiagonallyBottomLeftReturnsNewSquare() {
        Square expected = new Square(1,1);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void QueenMovingOutOfBoundsFileReturnsOriginalSquare() {
        Square expected = new Square(5,9);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(originalSquare, actual);
    }

    @Test
    public void QueenMovingOutOfBoundsRankReturnsOriginalSquare() {
        Square expected = new Square(10,5);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(originalSquare, actual);
    }

    @Test
    public void QueenMovingIncorrectlyReturnsOriginalSquare() {
        Square expected = new Square(6,8);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(originalSquare, actual);
    }
//TODO
//    @Test
//    public void QueenMovingDiscoversCheckReturnsOriginalSquare() {
//        Square expected = new Square(5,7);
//        Square actual = pieceLogic.MovePiece(originalSquare, expected);
//        Assert.assertEquals(originalSquare, actual);
//    }
//    @Test
//    public void QueenMovingStillInCheckReturnsOriginalSquare() {
//        Square expected = new Square(5,7);
//        Square actual = pieceLogic.MovePiece(originalSquare, expected);
//        Assert.assertEquals(originalSquare, actual);
//    }

}
