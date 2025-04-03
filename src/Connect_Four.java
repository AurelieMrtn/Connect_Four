import java.util.Scanner;

public class Connect_Four {
    public static void main(String[] args) {
        // Initialisation
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();

        // Game introduction
        int gameMode = chooseGameMode(scanner);

        // Launch chosen game
        switch (gameMode) {
            case 1: {
                twoPlayers(board, scanner);
            }
            case 2: {
                playerAgainstMachine(board, scanner);
            }
            case 3: {
                playerAgainstAI(board, scanner);
            }
        }
    }

    protected static int chooseGameMode(Scanner scanner) {
        int gameMode;
        System.out.println("-----------------------------------------------------------\n");
        System.out.println("\t\t\tHi! Welcome to connect four!");
        System.out.println("\nYou can start by choosing a mode. Type the choosen number:");
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

        return gameMode;
    }

    protected static void twoPlayers(Board board, Scanner scanner) {
        // Create two players
        System.out.print("Enter first player's name: ");
        Player playerOne = new Player (scanner.nextLine(), 'X');

        System.out.print("Enter second player's name: ");
        Player playerTwo = new Player (scanner.nextLine(), 'O');

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
                System.out.println("Good job! " + currentPlayer.getName() + " (" +currentPlayer.getSymbol() + ")" + " wins!");
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

    protected static void playerAgainstMachine(Board board, Scanner scanner) {

    }

    protected static void playerAgainstAI(Board board, Scanner scanner) {

    }
}