package PieceTests;

import chesson.server.logic.piecelogic.PieceLogic;
import chesson.server.logic.piecelogic.QueenLogic;
import chesson.server.models.Player;
import chesson.server.models.PlayingField;
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
        queen = new Queen(originalSquare,"test");
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

    @Test
    public void QueenMovingDiagonallyTopRightReturnsArrayList() {
        Square to = new Square(8,8);
        ArrayList<Square> result = pieceLogic.getSquaresInBetweenMove(originalSquare, to);
        int amountOfSquares = Math.abs(originalSquare.getFile() - to.getFile()) - 1;
        for(Square s: result) {
            Assert.assertEquals(s.getRank(), result.indexOf(s) + originalSquare.getRank() + 1);
            Assert.assertEquals(s.getFile(), result.indexOf(s) + originalSquare.getFile() + 1);
        }
        Assert.assertEquals(amountOfSquares, result.size());
    }

    @Test
    public void QueenMovingDiagonallyTopLeftReturnsArrayList() {
        Square to = new Square(8,2);
        ArrayList<Square> result = pieceLogic.getSquaresInBetweenMove(originalSquare, to);
        int amountOfSquares = Math.abs(originalSquare.getFile() - to.getFile()) - 1;
        for(Square s: result) {
            Assert.assertEquals(s.getRank(), result.indexOf(s) + originalSquare.getRank() + 1);
            Assert.assertEquals(s.getFile(), originalSquare.getFile() - result.indexOf(s) - 1);
        }
        Assert.assertEquals(amountOfSquares, result.size());
    }

    @Test
    public void QueenMovingDiagonallyBottomRightReturnsArrayList() {
        Square to = new Square(3,7);
        ArrayList<Square> result = pieceLogic.getSquaresInBetweenMove(originalSquare, to);
        int amountOfSquares = Math.abs(originalSquare.getFile() - to.getFile()) - 1;
        for(Square s: result) {
            Assert.assertEquals(s.getRank(), originalSquare.getRank() - result.indexOf(s) - 1);
            Assert.assertEquals(s.getFile(), result.indexOf(s) + originalSquare.getFile() + 1);
        }
        Assert.assertEquals(amountOfSquares, result.size());
    }

    @Test
    public void QueenMovingDiagonallyBottomLeftReturnsArrayList() {
        Square to = new Square(1,1);
        ArrayList<Square> result = pieceLogic.getSquaresInBetweenMove(originalSquare, to);
        int amountOfSquares = Math.abs(originalSquare.getFile() - to.getFile()) - 1;
        for(Square s: result) {
            Assert.assertEquals(s.getRank(), originalSquare.getRank() - result.indexOf(s) - 1);
            Assert.assertEquals(s.getFile(), originalSquare.getFile() - result.indexOf(s) - 1);
        }
        Assert.assertEquals(amountOfSquares, result.size());
    }
    @Test
    public void QueenMovingVerticallyPositiveReturnsArraylist() {
        Square to = new Square(5,8);
        ArrayList<Square> result = pieceLogic.getSquaresInBetweenMove(originalSquare, to);
        int amountOfSquares = Math.abs(originalSquare.getFile() - to.getFile()) - 1;
        for(Square s: result) {
            Assert.assertEquals(s.getFile(), originalSquare.getFile());
            Assert.assertEquals(s.getRank(), result.indexOf(s) + originalSquare.getRank() + 1);
        }
        Assert.assertEquals(amountOfSquares, result.size());
    }

    @Test
    public void QueenMovingVerticallyNegativeReturnsArraylist() {
        Square to = new Square(5,2);
        ArrayList<Square> result = pieceLogic.getSquaresInBetweenMove(originalSquare, to);
        int amountOfSquares = Math.abs(originalSquare.getFile() - to.getFile()) - 1;
        for(Square s: result) {
            Assert.assertEquals(s.getRank(), originalSquare.getRank());
            Assert.assertEquals(s.getFile(),  originalSquare.getFile() - result.indexOf(s) - 1);
        }
        Assert.assertEquals(amountOfSquares, result.size());
    }

    @Test
    public void QueenMovingHorizontallyPositiveReturnsArraylist() {
        Square to = new Square(8,5);
        ArrayList<Square> result = pieceLogic.getSquaresInBetweenMove(originalSquare, to);
        int amountOfSquares = Math.abs(originalSquare.getRank() - to.getRank()) - 1;
        for(Square s: result) {
            Assert.assertEquals(s.getFile(), originalSquare.getFile());
            Assert.assertEquals(s.getRank(), result.indexOf(s) + originalSquare.getRank() + 1);
        }
        Assert.assertEquals(amountOfSquares, result.size());
    }

    @Test
    public void QueenRookMovingHorizontallyNegativeReturnsArraylist() {
        Square to = new Square(2,5);
        ArrayList<Square> result = pieceLogic.getSquaresInBetweenMove(originalSquare, to);
        int amountOfSquares = Math.abs(originalSquare.getRank() - to.getRank()) - 1;
        for(Square s: result) {
            Assert.assertEquals(s.getFile(), originalSquare.getFile());
            Assert.assertEquals(s.getRank(), originalSquare.getRank() - result.indexOf(s) - 1);
        }
        Assert.assertEquals(amountOfSquares, result.size());
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
