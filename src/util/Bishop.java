package util;

import game.Game;
import game.Move;

public class Bishop extends Queen {
    public Bishop(boolean white) {
        super(white);
    }

    @Override
    public boolean isLegal(Move move, Game game) {
        if (!super.isLegal(move, game)) {
            return false;
        }
        
        int row0 = move.getRow0();
        int col0 = move.getCol0();
        int row1 = move.getRow1();
        int col1 = move.getCol1();

        // Check if the move is diagonal
        if (Math.abs(row1 - row0) != Math.abs(col1 - col0)) {
            return false;
        }

        // Check if the path is clear
        int dy = row1 > row0 ? 1 : -1;
        int dx = col1 > col0 ? 1 : -1;
        for (int r = row0 + dy, c = col0 + dx; r != row1; r += dy, c += dx) {
            if (game.getPiece(r, c) != null) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        return white ? "\u2657" : "\u265D";
    }
}
