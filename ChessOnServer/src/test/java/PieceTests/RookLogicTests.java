package PieceTests;

import chesson.server.logic.piecelogic.PieceLogic;
import chesson.server.logic.piecelogic.RookLogic;
import chesson.server.models.Lobby;
import chesson.server.models.Player;
import chesson.server.models.PlayingField;
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
    private PlayingField field;

    @BeforeEach
    private void SetUp() {
        pieceLogic = new RookLogic();
        player = new Player("Jesse", 400, new ArrayList<>());
        originalSquare = new Square(5,5);
        rook = new Rook(originalSquare, player, "test");
        player.addPiece(rook);
        field = new PlayingField();
    }

    @AfterEach
    void tearDown() {
        ;
    }

    @Test
    public void RookMovingIllegallyReturnsOriginalSquare() {
        Square expected = new Square(4,4);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(actual, originalSquare);
    }

    @Test
    public void RookMovingVerticallyPositiveReturnsNewSquare() {
        Square expected = new Square(5,8);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void RookMovingVerticallyNegativeReturnsNewSquare() {
        Square expected = new Square(5,2);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void RookMovingHorizontallyPositiveReturnsNewSquare() {
        Square expected = new Square(8,5);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void RookMovingHorizontallyNegativeReturnsNewSquare() {
        Square expected = new Square(2,5);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void RookMovingVerticallyPositiveReturnsArraylist() {
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
    public void RookMovingVerticallyNegativeReturnsArraylist() {
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
    public void RookMovingHorizontallyPositiveReturnsArraylist() {
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
    public void RookMovingHorizontallyNegativeReturnsArraylist() {
        Square to = new Square(2,5);
        ArrayList<Square> result = pieceLogic.getSquaresInBetweenMove(originalSquare, to);
        int amountOfSquares = Math.abs(originalSquare.getRank() - to.getRank()) - 1;
        for(Square s: result) {
            Assert.assertEquals(s.getFile(), originalSquare.getFile());
            Assert.assertEquals(s.getRank(), originalSquare.getRank() - result.indexOf(s) - 1);
        }
        Assert.assertEquals(amountOfSquares, result.size());
    }

    @Test
    public void RookMovingOutOfBoundsFileReturnsOriginalSquare() {
        Square to = new Square(1,9);
        Square actual = pieceLogic.MovePiece(originalSquare, to);
        Assert.assertEquals(originalSquare, actual);
    }

    @Test
    public void RookMovingOutOfBoundsRankReturnsOriginalSquare() {
        Square to = new Square(9,1);
        Square actual = pieceLogic.MovePiece(originalSquare, to);
        Assert.assertEquals(originalSquare, actual);
    }
}
