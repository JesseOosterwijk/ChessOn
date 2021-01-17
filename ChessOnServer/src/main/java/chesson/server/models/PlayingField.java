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

    private ArrayList<Piece> pieces = new ArrayList<>();

    public PlayingField() {
        this.squares = new ArrayList<>();
    }


    public ArrayList<Piece> getPieces(ArrayList<Player> players) {
        ArrayList<Piece> pieces = new ArrayList<>();
        for (Player player: players) {
            for (Piece piece: player.getPieces()) {
                pieces.add(piece);
            }
        }
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    public void attemptMove(Lobby lobby, Square from, Square to, String username, PlayingFieldController controller) {

        Player lobbyPlayer = lobby.getPlayer(username);
        Piece piece = getPieceByCoordinate(from, lobbyPlayer);

        if(lobby.getPlayers().indexOf(lobbyPlayer) == lobby.getTurn() && piece != null) {

            if(piece.tryMoveSquare(from, to) && !checkIfPiecePlayerIsPresentAtSquare(lobbyPlayer, to)) {
                piece.setSquare(to);
                if(checkForCheck(lobbyPlayer, lobby)) {
                    piece.setSquare(from);
                    lobby.setTurn(1 - lobby.getTurn());
                } else if (checkIfPiecePlayerIsPresentAtSquare(getOpponentPlayer(lobby, lobbyPlayer), to)) {
                    removePiecePlayerAtSquare(getOpponentPlayer(lobby, lobbyPlayer), to);
                }
                lobby.setTurn(1 - lobby.getTurn());
            }
        }
        controller.UpdatePieces(lobby.getPlayers(), this);
    }

    private boolean checkForCheck(Player player, Lobby lobby) {
        for(Piece piece: getOpponentPlayer(lobby, player).getPieces()) {
            if(piece.tryMoveSquare(piece.getSquare(), getKingSquarePlayer(player))) {
                return true;
            }
        }
        return false;
    }

    private Square getKingSquarePlayer(Player player) {
        for(Piece piece: player.getPieces()) {
            if(piece.getValue() == 0) {
                return piece.getSquare();
            }
        }
        return null;
    }

    public boolean MovesOverOtherPieces(Piece piece, Square from, Square to) {
        return false;
    }

    private Piece getPieceByCoordinate(Square square, Player player) {
        for(Piece piece: player.getPieces()) {
            if(piece.getSquare().getFile() == square.getFile() && piece.getSquare().getRank() == square.getRank()) {
                return piece;
            }
        }
        return null;
    }

    private boolean checkIfPiecePlayerIsPresentAtSquare(Player player, Square square) {
        for(Piece piece: player.getPieces()) {
            if(piece.getSquare().getFile() == square.getFile() && piece.getSquare().getRank() == square.getRank()) {
                return true;
            }
        }
        return false;
    }

    private Player getOpponentPlayer(Lobby lobby, Player player) {
        Player opponent;
        if(lobby.getPlayers().indexOf(player) == 0) {
            opponent = lobby.getPlayers().get(1);
        } else {
            opponent = lobby.getPlayers().get(0);
        }
        return opponent;
    }

    private void removePiecePlayerAtSquare(Player player, Square square) {
        Piece piece = getPieceByCoordinate(square, player);
        player.removePiece(piece);
    }
}
