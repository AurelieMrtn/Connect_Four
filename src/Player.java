import java.util.Scanner;

class Player {
    private String name;
    private char symbol;

    // Constructor
    protected Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    protected String getName() {
        return name;
    }

    protected char getSymbol() {
        return symbol;
    }

    // Allow player to choose a column
    protected int chooseColumn(Scanner scanner) {
        int column;
        do {
            System.out.print("Player " + name + " (" + symbol + "), choose a column between 1 and 7: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 7.");
                scanner.next();
            }
            column = scanner.nextInt() - 1;
        } while (column < 0 || column > 6);
        return column;
    }

}
