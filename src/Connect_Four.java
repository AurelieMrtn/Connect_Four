import java.util.Scanner;

public class Connect_Four {
    public static void main(String[] args) {
        // Initialisation
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();

        // Game introduction
        int gameMode = chooseGameMode(scanner);

        // Create two players
        System.out.print("Enter first player's name: ");
        Player playerOne = new Player (scanner.nextLine(), 'X');

        Player playerTwo = switch (gameMode) {
            case 1 -> {
                System.out.println("Enter second player's name: ");
                yield new Player(scanner.nextLine(), 'O');
            }
            case 2 -> {
                System.out.println("You are playing against a random machine!");
                yield new SimpleMachinePlayer('O');
            }
            case 3 -> {
                System.out.println("You are playing against the AI!");
                yield new AIPlayer('O');
            }
            default -> throw new IllegalStateException("Unexpected mode: " + gameMode);
        };

        Player currentPlayer = playerOne;
        boolean gameWon = false;
        boolean gameOver = false;

        while (!gameWon && !gameOver) {
            board.displayBoard();

            // Player plays
            int column;
            boolean validMove;
            do {
                column = currentPlayer.chooseColumn(scanner);
                validMove = board.drop(column, currentPlayer.getSymbol());

                if (!validMove) {
                    System.out.println("Column is full! Choose another one.");
                }
            } while (!validMove);

            // Check if there is a win and if so print it
            if (board.checkWin(currentPlayer.getSymbol())) {
                board.displayBoard();
                System.out.println("Good job! " + currentPlayer.getName() + " (" + currentPlayer.getSymbol() + ")" + " wins!");
                gameWon = true;
            }

            // If no win switch players
            currentPlayer = currentPlayer == playerOne ? playerTwo : playerOne;

            // Check if board is full
            gameOver = board.isFull();
            if (gameOver) {
                board.displayBoard();
                System.out.println("It's a tie!");
            }
        }

        // Close scanner to avoid memory leaks
        scanner.close();
    }

    protected static int chooseGameMode(Scanner scanner) {
        int gameMode;
        System.out.println("-----------------------------------------------------------\n");
        System.out.println("\t\t\tHi! Welcome to connect four!");
        System.out.println("\nYou can start by choosing a mode. Type the chosen number:");
        System.out.println("1: Two players.");
        System.out.println("2: One player against the machine playing randomly.");
        System.out.println("3: One player against a stronger AI.");
        System.out.println("\n-----------------------------------------------------------");

        do {
            System.out.print("Choose a number between 1 and 3: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 3.");
                scanner.next();
            }
            gameMode = scanner.nextInt();
        } while (gameMode < 1 || gameMode > 3);
        scanner.nextLine();

        return gameMode;
    }
}