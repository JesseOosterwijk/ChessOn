package chesson.server.messages;

import chesson.server.enums.MessageType;

import java.util.ArrayList;

public class Message {
    public String to;
    public int lobbyId;
    public String username;
    public MessageType messageType;
    public ArrayList<String> players;
    public String host;

    public Message() {
    }
}
