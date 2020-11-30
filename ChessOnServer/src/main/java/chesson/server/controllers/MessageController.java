package chesson.server.controllers;

import chesson.server.logic.ServerLogic;
import chesson.server.messages.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {
    private final SimpMessagingTemplate simpMessagingTemplate;
    private final ServerLogic logic = new ServerLogic();

    public MessageController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @MessageMapping("/move")
    public void movementUpdate(Message messageIn) {
    }

    @MessageMapping("/joinLobby")
    public void JoinLobby(Message messageIn) {
    }

    @MessageMapping("/createLobby")
    public void CreateLobby(Message messageIn) {

    }
}
