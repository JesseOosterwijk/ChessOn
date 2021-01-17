package chesson.server.models;

import chesson.server.models.pieces.*;
import lombok.Getter;
import lombok.Setter;

import javax.websocket.Session;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lobby {
    private ArrayList<Player> playerList = new ArrayList<>();
    private ArrayList<Session> sessionList;
    private PlayingField playingField;
    private int id;
    @Getter @Setter
    private int turn;

    public Lobby(int lobbyId, String username) {
        this.id = lobbyId;
        Player player = createPlayer(username);
        player.setHost();
        this.addPlayer(player);
        playingField = new PlayingField();
        turn = 0;
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

    public Exception startGame() {
        if(this.playerList.size() != 2) {
            return new Exception("crash");
        } else {
            Collections.shuffle(playerList);
            Player white = playerList.get(0);
            Player black = playerList.get(1);
            white.setPieces(setUpWhitePieces(white));
            black.setPieces(setUpBlackPieces(black));
        }
        return null;
    }

    public ArrayList<Piece> setUpWhitePieces(Player player) {
        ArrayList<Piece> pieces = new ArrayList<>();
        pieces.add(new Rook(new Square(0,7), "rook_white"));
        pieces.add(new Knight(new Square(1,7),"knight_white"));
        pieces.add(new Bishop(new Square(2,7),"bishop_white"));
        pieces.add(new Queen(new Square(3,7),"queen_white"));
        pieces.add(new King(new Square(4,7),"king_white"));
        pieces.add(new Bishop(new Square(5,7),"bishop_white"));
        pieces.add(new Knight(new Square(6,7),"knight_white"));
        pieces.add(new Rook(new Square(7,7),"rook_white"));

        pieces.add(new Pawn(new Square(0,6), "pawn_white"));
        pieces.add(new Pawn(new Square(1,6), "pawn_white"));
        pieces.add(new Pawn(new Square(2,6), "pawn_white"));
        pieces.add(new Pawn(new Square(3,6), "pawn_white"));
        pieces.add(new Pawn(new Square(4,6), "pawn_white"));
        pieces.add(new Pawn(new Square(5,6), "pawn_white"));
        pieces.add(new Pawn(new Square(6,6), "pawn_white"));
        pieces.add(new Pawn(new Square(7,6), "pawn_white"));
        return pieces;
    }

    public ArrayList<Piece> setUpBlackPieces(Player player) {
        ArrayList<Piece> pieces = new ArrayList<>();
        pieces.add(new Rook(new Square(0,0), "rook_black"));
        pieces.add(new Knight(new Square(1,0), "knight_black"));
        pieces.add(new Bishop(new Square(2,0), "bishop_black"));
        pieces.add(new Queen(new Square(3,0), "queen_black"));
        pieces.add(new King(new Square(4,0), "king_black"));
        pieces.add(new Bishop(new Square(5,0), "bishop_black"));
        pieces.add(new Knight(new Square(6,0), "knight_black"));
        pieces.add(new Rook(new Square(7,0), "rook_black"));

        pieces.add(new Pawn(new Square(0,1), "pawn_black"));
        pieces.add(new Pawn(new Square(1,1), "pawn_black"));
        pieces.add(new Pawn(new Square(2,1), "pawn_black"));
        pieces.add(new Pawn(new Square(3,1), "pawn_black"));
        pieces.add(new Pawn(new Square(4,1), "pawn_black"));
        pieces.add(new Pawn(new Square(5,1), "pawn_black"));
        pieces.add(new Pawn(new Square(6,1), "pawn_black"));
        pieces.add(new Pawn(new Square(7,1), "pawn_black"));
        return pieces;
    }
}
