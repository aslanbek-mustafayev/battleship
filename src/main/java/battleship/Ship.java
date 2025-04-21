package battleship;

abstract class Ship {

    protected int length;
    protected String[] parts;
    protected String name;

    public boolean isAfloat() {
        for (String s : parts) {
            if (!s.equals("X")) {
                return true;
            }
        }
        return false;
    }

    public void setShip(
        char charStart,
        char charEnd,
        int intStart,
        int intEnd
    ) {
        int rowStep = Integer.compare(charEnd, charStart);
        int colStep = Integer.compare(intEnd, intStart);
        for (int i = 0; i < length; i++) {
            this.parts[i] = String.format(
                "%c%d",
                (char) (charStart + i * rowStep),
                intStart + i * colStep
            );
        }
    }

    public void printRequest() {
        System.out.printf(
            "%nEnter the coordinates of the %s (%d cells):%n%n",
            this.name,
            this.length
        );
    }

    public boolean checkLength(
        char charStart,
        char charEnd,
        int intStart,
        int intEnd
    ) {
        int len =
            Math.abs(charStart - charEnd) + Math.abs(intStart - intEnd) + 1; //calculate the length of the given ship

        if (len == this.length) {
            return true;
        } else {
            System.out.println(
                "Error! Wrong length of the " + this.name + "! Try again:"
            );
            return false;
        }
    }
}

class AircraftCarrier extends Ship {

    public AircraftCarrier() {
        this.length = 5;
        this.parts = new String[5];
        this.name = "Aircraft Carrier";
    }
}

class Battleship extends Ship {

    public Battleship() {
        this.length = 4;
        this.parts = new String[4];
        this.name = "Battleship";
    }
}

class Submarine extends Ship {

    public Submarine() {
        this.length = 3;
        this.parts = new String[3];
        this.name = "Submarine";
    }
}

class Cruiser extends Ship {

    public Cruiser() {
        this.length = 3;
        this.parts = new String[3];
        this.name = "Cruiser";
    }
}

class Destroyer extends Ship {

    public Destroyer() {
        this.length = 2;
        parts = new String[2];
        name = "Destroyer";
    }
}
