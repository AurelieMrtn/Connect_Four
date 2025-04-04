import java.util.Scanner;

public class AIPlayer extends Player {
    private static final int MAX_DEPTH = 5;

    protected AIPlayer(char symbol) {
        super("AI", symbol);
    }

    protected char getSymbol() {
        return super.getSymbol();
    }

    @Override
    protected int chooseColumn(Scanner scanner) {
        int bestScore = Integer.MIN_VALUE;
        int bestColumn = -1;
        Board board = Board.getInstance();

        for (int col = 0; col < 7; col++) {
            if (board.isColumnAvailable(col)) {
                Board tempBoard = new Board(board);
                tempBoard.drop(col, getSymbol());

                int score = minimax(tempBoard, MAX_DEPTH, false, Integer.MIN_VALUE, Integer.MAX_VALUE);

                if (score > bestScore) {
                    bestScore = score;
                    bestColumn = col;
                }
            }
        }
        return bestColumn;
    }

    private int minimax(Board board, int depth, boolean isMaximizing, int alpha, int beta) {
        char aiSymbol = getSymbol();
        char playerSymbol = (aiSymbol == 'X') ? 'O' : 'X';

        if (board.checkWin(aiSymbol)) return 1000;
        if (board.checkWin(playerSymbol)) return -1000;
        if (board.isFull() || depth == 0) return evaluateBoard(board, aiSymbol);

        if (isMaximizing) {
            int maxScore = Integer.MIN_VALUE;
            for (int col = 0; col < 7; col++) {
                if (board.isColumnAvailable(col)) {
                    Board tempBoard = new Board(board);
                    tempBoard.drop(col, aiSymbol);

                    int score = minimax(tempBoard, depth - 1, false, alpha, beta);
                    maxScore = Math.max(maxScore, score);
                    alpha = Math.max(alpha, score);
                    if (beta <= alpha) break;
                }
            }
            return maxScore;
        } else {
            int minScore = Integer.MAX_VALUE;
            for (int col = 0; col < 7; col++) {
                if (board.isColumnAvailable(col)) {
                    Board tempBoard = new Board(board);
                    tempBoard.drop(col, playerSymbol);

                    int score = minimax(tempBoard, depth - 1, true, alpha, beta);
                    minScore = Math.min(minScore, score);
                    beta = Math.min(beta, score);
                    if (beta <= alpha) break;
                }
            }
            return minScore;
        }
    }

    private int evaluateBoard(Board board, char aiSymbol) {
        char playerSymbol = (aiSymbol == 'X') ? 'O' : 'X';;
        int score = 0;

        if (board.checkWin(aiSymbol)) score += 1000;
        if (board.checkWin(playerSymbol)) score -= 1000;

        return score;
    }
}
