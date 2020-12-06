package chesson.server.controllers;

import chesson.server.enums.MessageType;
import chesson.server.logic.ServerLogic;
import chesson.server.messages.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

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
        serverLogic.joinLobby(messageIn.lobbyId, messageIn.players.get(0));
        Message messageOut = new Message();
        messageOut.messageType = MessageType.JOIN_LOBBY;
        messageOut.players = serverLogic.getPlayers(messageIn.lobbyId);
        messageOut.lobbyId = messageIn.lobbyId;
        messageOut.host = messageOut.players.get(0);
    }


    @MessageMapping("/createLobby")
    public void CreateLobby(Message messageIn) {
        Message messageOut = new Message();
        messageOut.lobbyId = serverLogic.createLobbyAndReturnId(messageIn.username);
        messageOut.players = serverLogic.getPlayers(messageOut.lobbyId);
        messageOut.messageType = MessageType.CREATE_LOBBY;
        messageOut.host = messageIn.players.get(0);
        simpMessagingTemplate.convertAndSend(messageIn.to, messageOut);
    }
}
