package PieceTests;

import chesson.server.logic.piecelogic.KingLogic;
import chesson.server.logic.piecelogic.PieceLogic;
import chesson.server.models.Lobby;
import chesson.server.models.Player;
import chesson.server.models.PlayingField;
import chesson.server.models.Square;
import chesson.server.models.pieces.King;
import chesson.server.models.pieces.Piece;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class KingLogicTests {
    private PieceLogic pieceLogic;
    private Player player;
    private Square originalSquare;
    private Piece king;
    private PlayingField field;

    @BeforeEach
    private void SetUp() {
        pieceLogic = new KingLogic();
        field = new PlayingField();
        player = new Player("Jesse", 400, new ArrayList<>());
        originalSquare = new Square(5,5);
        king = new King(originalSquare, "test");
        player.addPiece(king);
    }

    @Test
    public void KingMovingHorizontallyPositiveReturnsNewSquare() {
        Square expected = new Square(5,6);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void KingMovingHorizontallyNegativeReturnsNewSquare() {
        Square expected = new Square(5,4);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void KingMovingVerticallyPositiveReturnsNewSquare() {
        Square expected = new Square(6,5);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void KingMovingVerticallyNegativeReturnsNewSquare() {
        Square expected = new Square(4,5);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void KingMovingDiagonallyTopRightReturnsNewSquare() {
        Square expected = new Square(6,6);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void KingMovingDiagonallyTopLeftReturnsNewSquare() {
        Square expected = new Square(6,4);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void KingMovingDiagonallyBottomRightReturnsNewSquare() {
        Square expected = new Square(4,6);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void KingMovingDiagonallyBottomLeftReturnsNewSquare() {
        Square expected = new Square(4,4);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void KingMovingOutOfBoundsFileReturnsOriginalSquare() {
        Square origin = new Square(8,8);
        Square to = new Square(8,9);
        Square actual = pieceLogic.MovePiece(origin, to);
        Assert.assertEquals(origin, actual);
    }

    @Test
    public void KingMovingOutOfBoundsRankReturnsOriginalSquare() {
        Square origin = new Square(8,8);
        Square to = new Square(9,8);
        Square actual = pieceLogic.MovePiece(origin, to);
        Assert.assertEquals(origin, actual);
    }

    @Test
    public void KingMovingMoreThanOneSquareFileReturnsOriginalSquare() {
        Square expected = new Square(5,3);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(originalSquare, actual);
    }

    @Test
    public void KingMovingMoreThanOneSquareRankReturnsOriginalSquare() {
        Square expected = new Square(7,5);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(originalSquare, actual);
    }

//TODO
//    @Test
//    public void KingMovingDiscoversCheckReturnsOriginalSquare() {
//        Square expected = new Square(5,7);
//        Square actual = pieceLogic.MovePiece(originalSquare, expected);
//        Assert.assertEquals(originalSquare, actual);
//    }
//    @Test
//    public void KingMovingStillInCheckReturnsOriginalSquare() {
//        Square expected = new Square(5,7);
//        Square actual = pieceLogic.MovePiece(originalSquare, expected);
//        Assert.assertEquals(originalSquare, actual);
//    }
}
