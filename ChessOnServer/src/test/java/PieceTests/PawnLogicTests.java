package PieceTests;

import chesson.server.logic.piecelogic.PawnLogic;
import chesson.server.logic.piecelogic.PieceLogic;
import chesson.server.models.Lobby;
import chesson.server.models.Player;
import chesson.server.models.PlayingField;
import chesson.server.models.Square;
import chesson.server.models.pieces.Pawn;
import chesson.server.models.pieces.Piece;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PawnLogicTests {
    private PieceLogic pieceLogic;
    private Player player;
    private Square originalSquare;
    private Piece pawn;
    private PlayingField field;

    @BeforeEach
    private void SetUp() {
        pieceLogic = new PawnLogic();
        player = new Player("Jesse", 400, new ArrayList<>());
        originalSquare = new Square(2,5);
        pawn = new Pawn(originalSquare, player, "test");
        player.addPiece(pawn);
        field = new PlayingField();
    }

    @Test
    public void PawnMovingOneSquareVerticallyReturnsNewSquare() {
        Square expected = new Square(3,5);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void PawnMovingTwoSquaresVerticallyFromSecondRankReturnsNewSquare() {
        Square expected = new Square(4,5);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void PawnMovingMoreThanOneSquareReturnsOriginalSquare() {
        Square origin = new Square(3,5);
        Square expected = new Square(5,5);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void PawnMovingToDifferentFileReturnsOriginalSquare() {
        Square expected = new Square(2,6);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void PawnMovingIncorrectlyReturnsOriginalSquare() {
        Square expected = new Square(7,3);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void PawnMovingOutOfBoundsReturnsOriginalSquare() {
        Square origin = new Square(8,5);
        Square expected = new Square(9,5);
        Square actual = pieceLogic.MovePiece(origin, expected);
        Assert.assertEquals(origin, actual);
    }

//TODO
//    @Test
//    public void PawnMovingDiscoversCheckReturnsOriginalSquare() {
//        Square expected = new Square(5,7);
//        Square actual = pieceLogic.MovePiece(originalSquare, expected);
//        Assert.assertEquals(expected, actual);
//    }
//    @Test
//    public void PawnMovingStillInCheckReturnsOriginalSquare() {
//        Square expected = new Square(5,7);
//        Square actual = pieceLogic.MovePiece(originalSquare, expected);
//        Assert.assertEquals(expected, actual);
//    }
}
