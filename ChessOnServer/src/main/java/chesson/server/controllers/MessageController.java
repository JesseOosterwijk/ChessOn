package chesson.server.controllers;

import chesson.server.enums.MessageType;
import chesson.server.logic.ServerLogic;
import chesson.server.messages.Message;
import chesson.server.models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

@Controller
public class MessageController {
    private final SimpMessagingTemplate simpMessagingTemplate;
    private final ServerLogic serverLogic;

    @Autowired
    public MessageController(SimpMessagingTemplate simpMessagingTemplate, ServerLogic serverLogic) {
        this.simpMessagingTemplate = simpMessagingTemplate;
        this.serverLogic = serverLogic;
    }

    @MessageMapping("/joinLobby")
    public void JoinLobby(Message messageIn) {
        serverLogic.joinLobby(messageIn.lobbyId, messageIn.username);
        Message messageOut = new Message();
        messageOut.messageType = MessageType.JOIN_LOBBY;
        messageOut.players = serverLogic.getPlayers(messageIn.lobbyId);
        messageOut.lobbyId = messageIn.lobbyId;
        SendMessageToPlayers(messageOut, messageOut.players);
    }


    @MessageMapping("/createLobby")
    public void CreateLobby(Message messageIn) {
        Message messageOut = new Message();
        messageOut.lobbyId = serverLogic.createLobbyAndReturnId(messageIn.username);
        messageOut.players = serverLogic.getPlayers(messageOut.lobbyId);
        messageOut.messageType = MessageType.CREATE_LOBBY;
        messageOut.host = messageOut.players.get(0);
        simpMessagingTemplate.convertAndSend(messageIn.to, messageOut);
    }

    private void SendMessageToPlayers(Message message, ArrayList<Player> players) {
        for (Player p : players) {
            String to = "/topic/" + p.getName();
            simpMessagingTemplate.convertAndSend(to, message);
        }
    }
}
