package play;
import game.*;
import java.util.Scanner;

public class Play {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;
        Game game = null;
        String player1 = "";
        String player2 = "";

        while (true) {
            System.out.println("Enter the Command: ");
            command = scanner.nextLine();

            if (command.startsWith("new game ")) {
                if (game != null) {
                    System.out.println("A game is already in progress.");
                } else {
                    String[] players = command.split(" ");
                    if (players.length != 4) {
                        System.out.println("Invalid command.");
                    } else {
                        player1 = players[2];
                        player2 = players[3];
                        game = new Game(player1, player2);
                        System.out.println(player1 + " vs " + player2);
                        game.showBoard(System.out);
                    }
                }
            } else if (command.startsWith("mv ")) {
                if (game == null) {
                    System.out.println("No game in progress.");
                } else {
                    String[] moveString = command.split(" ");
                    if (moveString.length != 2) {
                        System.out.println("Invalid command.");
                    } else {
                        Move move  = new Move(moveString[1]);
                        boolean success = game.move(move);
                        if (success) {
                            game.showBoard(System.out);
                        } else {
                            System.out.println("Illegal move.");
                        }
                    }
                }
            } else if (command.startsWith("cp ")) {
                if (game == null) {
                    System.out.println("No game in progress.");
                } else {
                    String[] capture = command.split(" ");
                    if (capture.length != 2) {
                        System.out.println("Invalid command.");
                    } else {
                    	Move move  = new Move(capture[1]);
                        boolean success = game.move(move);
                        if (success) {
                        	game.showBoard(System.out);
                        } else {
                           System.out.println("Illegal capture.");
                        }
                    }
                }
            } else if (command.equals("undo")) {
                if (game == null) {
                    System.out.println("No game in progress.");
                } else {
                    boolean success = game.undo();
                    if (success) {
                        game.showBoard(System.out);
                    } else {
                        System.out.println("Undo not possible.");
                    }
                }
            } else if (command.equals("print status")) {
                if (game == null) {
                    System.out.println("No game in progress.");
                } else {
                    game.printStatus();
                }
            } else if (command.equals("exit")) {
                break;
            } else {
                System.out.println("Invalid command.");
            }
        }

        scanner.close();
    }
}
