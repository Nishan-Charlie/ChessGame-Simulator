package util;

import game.Game;
import game.Move;

public class Knight extends Piece{
    public Knight(boolean white) {
        super(white);
    }

    @Override
    public boolean isLegal(Move move, Game game) {
        if(!super.isLegal(move, game)) {
            return false;
        }

        int row0 = move.getRow0();
        int col0 = move.getCol0();
        int row1 = move.getRow1();
        int col1 = move.getCol1();

        int absRowDiff = Math.abs(row1 - row0);
        int absColDiff = Math.abs(col1 - col0);

        // A knight can move in an L-shape: two squares vertically and one square horizontally
        // OR two squares horizontally and one square vertically
        if ((absRowDiff == 2 && absColDiff == 1) || (absRowDiff == 1 && absColDiff == 2)) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return white ? "\u2658" : "\u265E";
    }
}
