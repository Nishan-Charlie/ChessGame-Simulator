package game;

import java.io.PrintStream;
import java.util.*;
import util.*;



public class Game {
    private String player1, player2;
    private ArrayList<Move> moves;
    private Square[][] board;
    private ArrayList<Piece> capturedPieces;

    public Piece getPiece(int row, int col) {
        return board[row][col].getOccupant();
    }

    public boolean isWhiteTurn() {
        return moves.size() % 2 == 0;
    }

    public String getPlayer1() {
        return player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public Game(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
        moves = new ArrayList<Move>();
        board = new Square[8][8];
        capturedPieces = new ArrayList<Piece>();
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                boolean white = (row + col) % 2 == 0;
                if (row == 1)
                    board[row][col] = new Square(white, new Pawn(false));
                else if (row == 6)
                    board[row][col] = new Square(white, new Pawn(true));
                else if (row == 7 || row == 0) {
                    if (col == 0 || col == 7)
                        board[row][col] = new Square(white, new Rook(row == 7));
                    else if (col == 1 || col == 6)
                        board[row][col] = new Square(white, new Knight(row == 7));
                    else if (col == 2 || col == 5)
                        board[row][col] = new Square(white, new Bishop(row == 7));
                    else if (col == 3)
                        board[row][col] = new Square(white, new Queen(row == 7));
                    else
                        board[row][col] = new Square(white, new King(row == 7));
                } else
                    board[row][col] = new Square(white, null);
            }
        }
    }

    public boolean move(Move move) {
        Square src = board[move.getRow0()][move.getCol0()], dst = board[move.getRow1()][move.getCol1()];
        if (src.getOccupant() == null || !src.getOccupant().isLegal(move, this))
            return false;
        Piece capturedPiece = dst.getOccupant();
        if (capturedPiece != null) {
            capturedPieces.add(capturedPiece);
            System.out.println("Captured piece: " + capturedPiece.toString());
        }
        moves.add(move);
        dst.setOccupant(src.getOccupant());
        src.setOccupant(null);
        return true;
    }

    public boolean undo() {
        if (moves.size() == 0) {
            return false;
        }
        Move move = moves.remove(moves.size() - 1);
        Square src = board[move.getRow1()][move.getCol1()], dst = board[move.getRow0()][move.getCol0()];
        Piece movedPiece = src.getOccupant();
        Piece capturedPiece = capturedPieces.size() > 0 ? capturedPieces.remove(capturedPieces.size() - 1) : null;
        if (capturedPiece != null) {
            dst.setOccupant(capturedPiece);
        }    if (movedPiece != null) {
            src.setOccupant(null);
            dst.setOccupant(movedPiece);
        }

        return true;
    }

    

    @Override
    public String toString() {
        return moves.toString();
    }

    public void showBoard(PrintStream stream) {
        stream.println(player2 + "\n__________________________________________________________");
        stream.println("   a\tb\tc\td\te\tf\tg\th"); // add this line for column names
        for (int row = 0; row < 8; row++) {
            for (int col = -1; col < 8; col++) {
                if (col < 0)
                    stream.print(8 - row);
                else if (getPiece(row, col) != null)
                    stream.print(getPiece(row, col));
                stream.print(col == -1 ? "  " : col != 7 ? "\t" : row != 7 ? "\n\n\n" : "\n");
            }
        }
        stream.println("   a\tb\tc\td\te\tf\tg\th"); // add this line for column names
        stream.println("__________________________________________________________\n" + player1);
    }


    public void printStatus() {
        System.out.println("Current board status:\n");
        showBoard(System.out);
        System.out.println("Moves played in the game:");
        for (int i = 0; i < moves.size(); i++) {
            Move move = moves.get(i);
            Piece movedPiece = board[move.getRow1()][move.getCol1()].getOccupant();
            String player = (i % 2 == 0) ? player1 : player2;
        
                System.out.println(player + " moves: " + move.toString() + " (" + movedPiece.toString() + ")");
        }
    }


}
