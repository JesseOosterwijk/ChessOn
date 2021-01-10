package chesson.server.models;

import chesson.server.models.pieces.*;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int Rating;
    private List<Piece> pieces;
    private boolean isHost;

    public Player(String name, int rating, List<Piece> pieces) {
        this.name = name;
        Rating = rating;
        this.pieces = pieces;
        this.isHost = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsHost() {
        return this.isHost;
    }

    public void setHost() {
        this.isHost = true;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int rating) {
        Rating = rating;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public void addPiece(Piece piece) {
        this.pieces.add(piece);
    }

//    public void removePiece(Piece piece) {
//        for(Piece p: pieces) {
//            if(p.getSquare().getRank() == piece.getSquare().getRank() && p.getSquare().getFile() == piece.getSquare().getFile()) {
//                this.pieces.remove(piece);
//            }
//        }
//    }
}
