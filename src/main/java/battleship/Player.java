package battleship;

import java.util.Scanner;

public class Player {

    public Battlefield myField;
    public String name;

    public Player(Scanner scanner, String name) {
        this.myField = new Battlefield();
        this.name = name;
        System.out.printf(
            "%s, place your ships on the game field%n%n",
            this.name
        );
        this.myField.printField();
        this.myField.setAllShips(scanner);
        System.out.println("Press Enter and pass the move to another player");
    }

    public void shoot(Scanner scanner, Battlefield enemyField) {
        char letter = 0;
        int num = 0;
        String shot = "A1";

        enemyField.printFoggyField();
        System.out.println("---------------------");
        myField.printField();
        System.out.printf("%n%s, it's your turn:%n", this.name);

        while (!enemyField.gameOver()) {
            shot = scanner.nextLine();
            letter = shot.charAt(0);
            num = Integer.parseInt(shot.substring(1));
            if (enemyField.coordinateValidator(letter, num)) {
                if (enemyField.gameField[letter - 64][num].equals("~")) {
                    enemyField.gameField[letter - 64][num] = "M";
                    System.out.println("You missed!");
                    break;
                } else {
                    enemyField.gameField[letter - 64][num] = "X";
                    enemyField.findHitShip(shot);
                    break;
                }
            } else {
                System.out.println(
                    "Error! You entered the wrong coordinates! Try again:"
                );
            }
        }
    }
}
