package chesson.server.controllers;

import chesson.server.enums.MessageType;
import chesson.server.logic.ServerLogic;
import chesson.server.messages.PlayingFieldMessage;
import chesson.server.models.Lobby;
import chesson.server.models.Player;
import chesson.server.models.PlayingField;
import chesson.server.models.Square;
import chesson.server.models.pieces.Pawn;
import chesson.server.models.pieces.Piece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PlayingFieldController {
    private final SimpMessagingTemplate simpMessagingTemplate;
    private ServerLogic serverLogic;

    @Autowired
    public PlayingFieldController(SimpMessagingTemplate simpMessagingTemplate, ServerLogic serverLogic) {
        this.simpMessagingTemplate = simpMessagingTemplate;
        this.serverLogic = serverLogic;
    }

    @MessageMapping("/move")
    public void MovePiece(PlayingFieldMessage messageIn) {
        PlayingFieldMessage messageOut = new PlayingFieldMessage();
        Lobby lobby = serverLogic.getLobby(messageIn.lobbyId);
        PlayingField field = lobby.getPlayingField();
        field.attemptMove(lobby, messageIn.squareFrom, messageIn.squareTo, messageIn.username, this);
    }

    public void UpdatePieces(ArrayList<Player> players, PlayingField playingField) {
        PlayingFieldMessage message = new PlayingFieldMessage();
        message.messageType = MessageType.MOVE_PIECE;
        message.players = players;
        message.pieces = playingField.getPieces();
        SendMessageToPlayers(message, players);
    }

    private void SendMessageToPlayers(PlayingFieldMessage message, ArrayList<Player> players) {
        for (Player p : players) {
            String to = "/topic/" + p.getName();
            simpMessagingTemplate.convertAndSend(to, message);
        }
    }

    private Piece getPieceByCoordinate(Square square, List<Piece> pieces) {
        for(Piece piece: pieces) {
            if(piece.getSquare().getFile() == square.getFile() && piece.getSquare().getRank() == square.getRank()) {
                return piece;
            }
        }
        return new Pawn(new Square(0,0), new Player("henk", 0, new ArrayList<Piece>()), "pawn");
    }
}
