package chesson.server.models;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Square {
    private int rank;
    private int file;

    public Square(int rank, int file) {
        this.rank = rank;
        this.file = file;
    }

    public int getRank() {
        return rank;
    }

    public int getFile() {
        return file;
    }
}
