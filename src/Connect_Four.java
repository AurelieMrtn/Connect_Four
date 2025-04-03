import java.util.Scanner;

public class Connect_Four {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();

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
}