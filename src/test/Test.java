package test;
import game.*;

public class Test {
    public static void main(String[] args) {
    	
        // Set the character encoding to UTF-8
        System.setProperty("file.encoding", "UTF-8");
    	
        Game game = new Game("Kasparov-White", "Karpov-Black");
        game.showBoard(System.out);
        
        // Testing legal moves
        System.out.println("Make a move: d2d4");
        if (game.move(new Move("d2d4"))) game.showBoard(System.out);
        else System.out.println("Illegal move!");
        
        System.out.println("Make a move: c7c5");
        if (game.move(new Move("c7c5"))) game.showBoard(System.out);
        else System.out.println("Illegal move!");
        
        System.out.println("Make a move: d4c5");
        if (game.move(new Move("d4c5"))) game.showBoard(System.out);
        else System.out.println("Illegal move!");
        
        System.out.println("Make a move: b8c6");
        Move move = new Move("b8c6");
        if (game.move(move)) {
        	game.showBoard(System.out);
        	System.out.println("Captured piece: " + game.getPiece(move.getRow0(), move.getCol0()));
        }
        else System.out.println("Illegal move!");
        
        System.out.println("Make a move: c5d6");
     
        if (game.move(new Move("c5d6"))) { 
        	game.showBoard(System.out);
//        	System.out.println("Captured piece: " + game.getPiece(move.getRow0(), move.getRow0()));
        }
        else System.out.println("Illegal move!");
        
        // Testing capturing
        System.out.println("Make a move: c6d4");
        Move move1 = new Move("c6d4");
        if (game.move(move1)){ 
            game.showBoard(System.out);
            System.out.println("Captured piece: " + game.getPiece(move1.getRow0(), move1.getRow0()));
        }
        else System.out.println("Illegal move!");
        
        // Testing illegal moves
        System.out.println("Make a move: d6e5"); // Invalid piece move
        if (game.move(new Move("d6e5"))) game.showBoard(System.out);
        else System.out.println("Illegal move!");
        
     // Legal moves
        System.out.println("Make a move: g1f3");
        if (game.move(new Move("g1f3"))) game.showBoard(System.out);
        else System.out.println("Illegal move!");

        System.out.println("Make a move: g8f6");
        if (game.move(new Move("g8f6"))) game.showBoard(System.out);
        else System.out.println("Illegal move!");

        System.out.println("Make a move: d1h5");
        if (game.move(new Move("d1h5"))) game.showBoard(System.out);
        else System.out.println("Illegal move!");

        System.out.println("Make a move: c8g4");
        if (game.move(new Move("c8g4"))) game.showBoard(System.out);
        else System.out.println("Illegal move!");

        System.out.println("Make a move: f1c4");
        if (game.move(new Move("f1c4"))) game.showBoard(System.out);
        else System.out.println("Illegal move!");

        System.out.println("Make a move: f8c5");
        if (game.move(new Move("f8c5"))) game.showBoard(System.out);
        else System.out.println("Illegal move!");

        System.out.println("Make a move: e2e3");
        if (game.move(new Move("e2e3"))) game.showBoard(System.out);
        else System.out.println("Illegal move!");

        System.out.println("Make a move: e7e6");
        if (game.move(new Move("e7e6"))) game.showBoard(System.out);
        else System.out.println("Illegal move!");

        System.out.println("Make a move: f3g5");
        if (game.move(new Move("f3g5"))) game.showBoard(System.out);
        else System.out.println("Illegal move!");

        System.out.println("Make a move: f6g4");
        if (game.move(new Move("f6g4"))) game.showBoard(System.out);
        else System.out.println("Illegal move!");

        System.out.println("Make a move: c4f7");
        if (game.move(new Move("c4f7"))) game.showBoard(System.out);
        else System.out.println("Illegal move!");

        System.out.println("Make a move: c5c4");
        if (game.move(new Move("c5c4"))) game.showBoard(System.out);
        else System.out.println("Illegal move!");

        System.out.println("Make a move: b2b3");
        if (game.move(new Move("b2b3"))) game.showBoard(System.out);
        else System.out.println("Illegal move!");

        System.out.println("Make a move: b7b6");
        if (game.move(new Move("b7b6"))) game.showBoard(System.out);
        else System.out.println("Illegal move!");

        System.out.println("Make a move: d2d3");
        if (game.move(new Move("d2d3"))) game.showBoard(System.out);
        else System.out.println("Illegal move!");

        System.out.println("Make a move: d7d6");
        if (game.move(new Move("d7d6"))) game.showBoard(System.out);
        else System.out.println("Illegal move!");
        
     // Testing captures
        System.out.println("Make a move: e5d4");
        if (game.move(new Move("e5d4"))){ 
            game.showBoard(System.out);
        }
        else System.out.println("Illegal move!");

        System.out.println("Make a move: f6d5");
        if (game.move(new Move("f6d5"))){ 
            game.showBoard(System.out);
        }
        else System.out.println("Illegal move!");

        System.out.println("Make a move: d4c3");
        if (game.move(new Move("d4c3"))){ 
            game.showBoard(System.out);
        }
        else System.out.println("Illegal move!");

        System.out.println("Make a move: f8c5");
        if (game.move(new Move("f8c5"))){ 
            game.showBoard(System.out);
        }
        else System.out.println("Illegal move!");

        System.out.println("Make a move: c3b2");
        if (game.move(new Move("c3b2"))){ 
            game.showBoard(System.out);
        }
        else System.out.println("Illegal move!");

        System.out.println("Make a move: e7e6");
        if (game.move(new Move("e7e6"))){ 
            game.showBoard(System.out);
        }
        else System.out.println("Illegal move!");

        System.out.println("Make a move: b2a1");
        if (game.move(new Move("b2a1"))){ 
            game.showBoard(System.out);
        }
        else System.out.println("Illegal move!");

        System.out.println("Make a move: c5d4");
        if (game.move(new Move("c5d4"))){ 
            game.showBoard(System.out);
        }
        else System.out.println("Illegal move!");

        System.out.println("Make a move: a1d4");
        if (game.move(new Move("a1d4"))){ 
            game.showBoard(System.out);
        }
        else System.out.println("Illegal move!");

        System.out.println("Make a move: g8h6");
        if (game.move(new Move("g8h6"))){ 
            game.showBoard(System.out);
        }
        else System.out.println("Illegal move!");


    }
}
