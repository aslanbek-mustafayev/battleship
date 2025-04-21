package battleship;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Player player1 = new Player(scanner, "Player 1");
        if (scanner.nextLine().isEmpty()) {
            Player player2 = new Player(scanner, "Player 2");

            Player currentPlayer = player2;

            do {
                if (scanner.nextLine().isEmpty() && currentPlayer == player1) {
                    currentPlayer = player2;
                    player2.shoot(scanner, player1.myField);
                } else {
                    currentPlayer = player1;
                    player1.shoot(scanner, player2.myField);
                }
                System.out.println(
                    "Press Enter and pass the move to another player"
                );
            } while (player1.myField.gameOver() == player2.myField.gameOver());
        }
    }
}
