package battleship;

import java.util.Scanner;

public class Battlefield {

    public String[][] gameField;
    private Ship[] allShips;

    public Battlefield() {
        this.gameField = setEmptyField();
        this.allShips = new Ship[] {
            new AircraftCarrier(),
            new Battleship(),
            new Submarine(),
            new Cruiser(),
            new Destroyer(),
        };
    }

    public String[][] setEmptyField() {
        String[][] emptyField = new String[11][11];
        emptyField[0][0] = " ";

        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                emptyField[i][j] = "~";
            }
            emptyField[0][i] = String.valueOf(i);
            emptyField[i][0] = Character.toString(64 + i);
        }
        return emptyField;
    }

    public void printField() {
        for (String[] row : gameField) {
            System.out.println(String.join(" ", row));
        }
    }

    public void printFoggyField() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (gameField[i][j].equals("O")) {
                    System.out.print("~ ");
                } else {
                    System.out.print(gameField[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public void changeField(
        int charStart,
        int charEnd,
        int intStart,
        int intEnd
    ) {
        if (charStart > charEnd) { //iterate |
            for (int i = charStart; i >= charEnd; i--) { //        |
                gameField[i][intStart] = "O"; //        v
            }
        } else if (charStart < charEnd) { //iterate ^
            for (int i = charStart; i <= charEnd; i++) { //        |
                gameField[i][intStart] = "O"; //        |
            }
        } else if (intStart > intEnd) { //iterate <----
            for (int i = intStart; i >= intEnd; i--) {
                gameField[charStart][i] = "O";
            }
        } else { //iterate ---->
            for (int i = intStart; i <= intEnd; i++) {
                gameField[charStart][i] = "O";
            }
        }
        printField();
    }

    public boolean coordinateValidator(char letter, int number) {
        return letter >= 'A' && letter <= 'J' && number >= 1 && number <= 10; //Coordinate letter A <= '_' <= F  number  1 <= num <= 10 ?
    }

    public boolean coordinateValidator(
        char charStart,
        char charEnd,
        int intStart,
        int intEnd
    ) {
        return (
            charStart >= 'A' &&
            charStart <= 'J' && //start's letter check
            charEnd >= 'A' &&
            charEnd <= 'J' && //end's letter check
            intStart >= 1 &&
            intStart <= 10 && //start's number
            intEnd >= 1 &&
            intEnd <= 10 && //end's number
            (charStart == charEnd) ^ (intStart == intEnd)
        ); // Letter or number part of both start and end are the same?
    }

    public boolean positioning(String coordinates, Ship ship) {
        String[] points = coordinates.split(" ");
        char charStart = points[0].charAt(0); //start's letter
        char charEnd = points[1].charAt(0); //end's letter
        int intStart = Integer.parseInt(points[0].substring(1)); //start's number
        int intEnd = Integer.parseInt(points[1].substring(1)); //end's number

        if (
            coordinateValidator(charStart, charEnd, intStart, intEnd) &&
            ship.checkLength(charStart, charEnd, intStart, intEnd) &&
            checkPlacementArea(charStart, charEnd, intStart, intEnd)
        ) {
            ship.setShip(charStart, charEnd, intStart, intEnd);
            return true;
        } else {
            System.out.println("Error! Wrong ship location! Try again:");
            return false;
        }
    }

    public boolean checkPlacementArea(
        char charStart,
        char charEnd,
        int intStart,
        int intEnd
    ) {
        int upperEdge = Math.max(1, Math.min(charStart, charEnd) - 65); //adds a line above to check
        int downEdge = Math.min(10, Math.max(charStart, charEnd) - 63); //adds a line under to check
        int leftEdge = Math.max(1, Math.min(intStart, intEnd) - 1); //adds a line to the left to check
        int rightEdge = Math.min(10, Math.max(intStart, intEnd) + 1); //adds a line to the right to check

        for (int i = upperEdge; i <= downEdge; i++) {
            for (int j = leftEdge; j <= rightEdge; j++) {
                if (!this.gameField[i][j].equals("~")) {
                    System.out.println(
                        "Error! You placed it too close to another one. Try again:"
                    );
                    return false;
                }
            }
        }

        changeField(charStart - 64, charEnd - 64, intStart, intEnd);

        return true;
    }

    public void findHitShip(String shot) {
        for (Ship allShip : allShips) {
            for (int j = 0; j < allShip.parts.length; j++) {
                if (allShip.parts[j].equals(shot)) {
                    allShip.parts[j] = "X";
                    if (allShip.isAfloat()) {
                        System.out.println("You hit a ship!");
                        return;
                    } else if (gameOver()) {
                        System.out.println(
                            "You sank the last ship. You won. Congratulations!"
                        );
                        return;
                    } else {
                        System.out.println("You sank a ship!");
                        return;
                    }
                }
            }
        }
    }

    public boolean gameOver() {
        for (Ship ship : allShips) {
            if (ship.isAfloat()) {
                return false;
            }
        }

        return true;
    }

    public void setAllShips(Scanner scanner) {
        for (Ship ship : this.allShips) {
            ship.printRequest();
            while (true) {
                if (positioning(scanner.nextLine(), ship)) break;
            }
        }
    }
}
