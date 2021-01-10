package chesson.server.models;

import chesson.server.models.pieces.*;

import javax.websocket.Session;
import java.util.ArrayList;
import java.util.List;

public class Lobby {
    private ArrayList<Player> playerList = new ArrayList<>();
    private ArrayList<Session> sessionList;
    private PlayingField playingField;
    private int id;

    public Lobby(int lobbyId, String username) {
        this.id = lobbyId;
        Player player = createPlayer(username);
        player.setHost();
        this.addPlayer(player);
        playingField = new PlayingField();
        playingField.setPieces(setUpPieces());
    }

    public Player createPlayer(String username){
        List<Piece> pieces = new ArrayList<>();
        return new Player(username, 500, pieces);
    }
    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    public List<Session> getSessionList() {
        return sessionList;
    }

    public void setSessionList(ArrayList<Session> sessionList) {
        this.sessionList = sessionList;
    }

    public PlayingField getPlayingField() {
        return playingField;
    }

    public void setPlayingField(PlayingField playingField) {
        this.playingField = playingField;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Player> getPlayers() {
        return playerList;
    }

    public Player getPlayer(String username){
        return playerList.stream().filter(p -> p.getName().equals(username)).findAny().get();
    }

    public void addPlayer(Player player) {
        playerList.add(player);
    }

    private ArrayList<Piece> setUpPieces() {
        ArrayList<Piece> pieces = new ArrayList<>();
        pieces.add(new Rook(new Square(0,0), getPlayerList().get(0), "rook_black"));
        pieces.add(new Knight(new Square(1,0), getPlayerList().get(0), "knight_black"));
        pieces.add(new Bishop(new Square(2,0), getPlayerList().get(0), "bishop_black"));
        pieces.add(new Queen(new Square(3,0), getPlayerList().get(0), "queen_black"));
        pieces.add(new King(new Square(4,0), getPlayerList().get(0),"king_black"));
        pieces.add(new Bishop(new Square(5,0), getPlayerList().get(0), "bishop_black"));
        pieces.add(new Knight(new Square(6,0),getPlayerList().get(0), "knight_black"));
        pieces.add(new Rook(new Square(7,0), getPlayerList().get(0),"rook_black"));

        pieces.add(new Pawn(new Square(0,1), getPlayerList().get(0), "pawn_black"));
        pieces.add(new Pawn(new Square(1,1), getPlayerList().get(0), "pawn_black"));
        pieces.add(new Pawn(new Square(2,1), getPlayerList().get(0), "pawn_black"));
        pieces.add(new Pawn(new Square(3,1), getPlayerList().get(0), "pawn_black"));
        pieces.add(new Pawn(new Square(4,1), getPlayerList().get(0), "pawn_black"));
        pieces.add(new Pawn(new Square(5,1), getPlayerList().get(0), "pawn_black"));
        pieces.add(new Pawn(new Square(6,1), getPlayerList().get(0), "pawn_black"));
        pieces.add(new Pawn(new Square(7,1), getPlayerList().get(0), "pawn_black"));

        pieces.add(new Rook(new Square(0,7), getPlayerList().get(0), "rook_white"));
        pieces.add(new Knight(new Square(1,7), getPlayerList().get(0), "knight_white"));
        pieces.add(new Bishop(new Square(2,7), getPlayerList().get(0), "bishop_white"));
        pieces.add(new Queen(new Square(3,7), getPlayerList().get(0), "queen_white"));
        pieces.add(new King(new Square(4,7), getPlayerList().get(0), "king_white"));
        pieces.add(new Bishop(new Square(5,7), getPlayerList().get(0), "bishop_white"));
        pieces.add(new Knight(new Square(6,7), getPlayerList().get(0), "knight_white"));
        pieces.add(new Rook(new Square(7,7), getPlayerList().get(0), "rook_white"));

        pieces.add(new Pawn(new Square(0,6), getPlayerList().get(0), "pawn_white"));
        pieces.add(new Pawn(new Square(1,6), getPlayerList().get(0), "pawn_white"));
        pieces.add(new Pawn(new Square(2,6), getPlayerList().get(0), "pawn_white"));
        pieces.add(new Pawn(new Square(3,6), getPlayerList().get(0), "pawn_white"));
        pieces.add(new Pawn(new Square(4,6), getPlayerList().get(0), "pawn_white"));
        pieces.add(new Pawn(new Square(5,6), getPlayerList().get(0), "pawn_white"));
        pieces.add(new Pawn(new Square(6,6), getPlayerList().get(0), "pawn_white"));
        pieces.add(new Pawn(new Square(7,6), getPlayerList().get(0), "pawn_white"));
        return pieces;
    }
}
