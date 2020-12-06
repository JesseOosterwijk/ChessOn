package PieceTests;

import chesson.server.logic.piecelogic.BishopLogic;
import chesson.server.logic.piecelogic.PieceLogic;
import chesson.server.models.Player;
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

    @BeforeEach
    private void SetUp() {
        pieceLogic = new BishopLogic();
        player = new Player("Jesse", 400, new ArrayList<>());
        originalSquare = new Square(5,5);
        bishop = new Bishop(player, originalSquare);
        player.addPiece(bishop);
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

//TODO
//    @Test
//    public void BishopMovingDiscoversCheckReturnsOriginalSquare() {
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
