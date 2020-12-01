package chesson.server.controllers;

import chesson.server.logic.PieceLogic;
import chesson.server.messages.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class PieceController {

    private final SimpMessagingTemplate simpMessagingTemplate;
    private final PieceLogic pieceLogic;

    @Autowired
    public PieceController(SimpMessagingTemplate simpMessagingTemplate, PieceLogic pieceLogic) {
        this.simpMessagingTemplate = simpMessagingTemplate;
        this.pieceLogic = pieceLogic;
    }

    @MessageMapping("/movePiece")
    public void MovePiece(Message messageIn) {
    }

    @MessageMapping("/takePiece")
    public void TakePiece(Message messageIn) {
    }

    @MessageMapping("/promotePawn")
    public void PromotePawn(Message messageIn) {
    }
}
