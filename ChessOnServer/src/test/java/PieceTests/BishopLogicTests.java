package PieceTests;

import chesson.server.logic.piecelogic.BishopLogic;
import chesson.server.logic.piecelogic.PieceLogic;
import chesson.server.models.Lobby;
import chesson.server.models.Player;
import chesson.server.models.PlayingField;
import chesson.server.models.Square;
import chesson.server.models.pieces.Bishop;
import chesson.server.models.pieces.Piece;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BishopLogicTests {
    private PieceLogic pieceLogic;
    private Player player;
    private Square originalSquare;
    private Piece bishop;
    private PlayingField field;

    @BeforeEach
    private void SetUp() {
        pieceLogic = new BishopLogic();
        field = new PlayingField();
        player = new Player("Jesse", 400, new ArrayList<>());
        originalSquare = new Square(5,5);
        bishop = new Bishop(originalSquare, player, "test");
        player.addPiece(bishop);
    }

    @Test
    public void BishopMovingDiagonallyTopRightReturnsNewSquare() {
        Square expected = new Square(8,8);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void BishopMovingDiagonallyTopLeftReturnsNewSquare() {
        Square expected = new Square(8,2);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void BishopMovingDiagonallyBottomRightReturnsNewSquare() {
        Square expected = new Square(3,7);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void BishopMovingDiagonallyBottomLeftReturnsNewSquare() {
        Square expected = new Square(1,1);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void BishopMovingIncorrectlyReturnsOriginalSquare() {
        Square to = new Square(2,1);
        Square actual = pieceLogic.MovePiece(originalSquare, to);
        Assert.assertEquals(originalSquare, actual);
    }

    @Test
    public void BishopMovingOutOfBoundsReturnsOriginalSquare() {
        Square to = new Square(9,9);
        Square actual = pieceLogic.MovePiece(originalSquare, to);
        Assert.assertEquals(originalSquare, actual);
    }

    @Test
    public void BishopMovingDiagonallyTopRightReturnsArrayList() {
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
    public void BishopMovingDiagonallyTopLeftReturnsArrayList() {
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
    public void BishopMovingDiagonallyBottomRightReturnsArrayList() {
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
    public void BishopMovingDiagonallyBottomLeftReturnsArrayList() {
        Square to = new Square(1,1);
        ArrayList<Square> result = pieceLogic.getSquaresInBetweenMove(originalSquare, to);
        int amountOfSquares = Math.abs(originalSquare.getFile() - to.getFile()) - 1;
        for(Square s: result) {
            Assert.assertEquals(s.getRank(), originalSquare.getRank() - result.indexOf(s) - 1);
            Assert.assertEquals(s.getFile(), originalSquare.getFile() - result.indexOf(s) - 1);
        }
        Assert.assertEquals(amountOfSquares, result.size());
    }
}
