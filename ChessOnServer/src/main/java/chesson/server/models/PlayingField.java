package chesson.server.models;

import chesson.server.controllers.PlayingFieldController;
import chesson.server.logic.LobbyLogic;
import chesson.server.logic.PlayingFieldLogic;
import chesson.server.models.pieces.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class PlayingField {
    private final ArrayList<Square> squares;

    @Getter
    private ArrayList<Piece> pieces = new ArrayList<>();

    public PlayingField() {
        this.squares = new ArrayList<>();
    }


    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    public void attemptMove(Lobby lobby, Square from, Square to, String username, PlayingFieldController controller) {
        Player lobbyPlayer = lobby.getPlayer(username);
        Piece piece = getPieceByCoordinate(from);
        if(piece.tryMoveSquare(from, to)) {
            piece.setSquare(to);
        }
        controller.UpdatePieces(lobby.getPlayers(), this);
    }

    private boolean checkForCheck() {
        for(Piece piece: this.getPieces()) {
            if(piece.tryMoveSquare(piece.getSquare(), getKingSquare())) {
                return true;
            }
        }
        return false;
    }

    private Square getKingSquare() {
        for(Piece piece: this.getPieces()) {
            if(piece.getValue() == 0) {
                return piece.getSquare();
            }
        }
        return null;
    }

    public boolean MovesOverOtherPieces(Piece piece, Square from, Square to) {
        return false;
    }

    private Piece getPieceByCoordinate(Square square) {
        for(Piece piece: this.getPieces()) {
            if(piece.getSquare().getFile() == square.getFile() && piece.getSquare().getRank() == square.getRank()) {
                return piece;
            }
        }
        return new Pawn(new Square(0,0), new Player("henk", 0, new ArrayList<>()), "pawn");
    }


}
