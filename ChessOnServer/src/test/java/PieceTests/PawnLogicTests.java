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
        originalSquare = new Square(2,1);
        pawn = new Pawn(originalSquare, "test");
        player.addPiece(pawn);
        field = new PlayingField();
    }

    @Test
    public void PawnMovingOneSquareVerticallyReturnsNewSquare() {
        Square expected = new Square(2,2);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void PawnMovingTwoSquaresVerticallyFromSecondRankReturnsNewSquare() {
        Square expected = new Square(2,3);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void PawnMovingMoreThanOneSquareReturnsOriginalSquare() {
        Square origin = new Square(2,4);
        Square expected = new Square(2, 6);
        Square actual = pieceLogic.MovePiece(origin, expected);
        Assert.assertEquals(origin, actual);
    }

    @Test
    public void PawnMovingToDifferentRankReturnsOriginalSquare() {
        Square expected = new Square(3,1);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(originalSquare, actual);
    }

    @Test
    public void PawnMovingIncorrectlyReturnsOriginalSquare() {
        Square expected = new Square(7,3);
        Square actual = pieceLogic.MovePiece(originalSquare, expected);
        Assert.assertEquals(originalSquare, actual);
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
