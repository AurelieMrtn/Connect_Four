class Board {
    private char[][] grid;
    private final int ROWS = 6;
    private final int COLUMNS = 7;
    private final char EMPTY = '.';

    // Constructor: initialize empty board
    protected Board() {
        grid = new char[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                grid[i][j] = EMPTY;
            }
        }
    }

    // Methods
    // Drop piece in a board column (last empty row in that column)
    protected boolean drop(int column, char symbol) {
        for (int i = ROWS - 1; i >= 0; i--) {
            if (grid[i][column] == EMPTY) {
                grid[i][column] = symbol;
                return true;
            }
        }
        return false;
    }

    // Display board
    protected void displayBoard() {
        for (char[] row: grid) {
            for (char cell: row) {
                System.out.print("| " + cell + " ");
            }
            System.out.println("|");
        }
        System.out.println("-----------------------------");
    }

    // Victory conditions (horizontal, vertical, diagonal)
    protected boolean checkWin(char symbol) {
        return checkHorizontal(symbol) || checkVertical(symbol) || checkDiagonal(symbol);
    }

    private boolean checkHorizontal(char symbol) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS - 3; j++) {
                if (grid[i][j] == symbol && grid[i][j + 1] == symbol && grid[i][j + 2] == symbol && grid[i][j + 3] == symbol) return true;
            }
        }
        return false;
    }

    private boolean checkVertical(char symbol) {
        for (int i = 0; i < ROWS - 3; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (grid[i][j] == symbol && grid[i + 1][j] == symbol && grid[i + 2][j] == symbol && grid[i + 3][j] == symbol) return true;
            }
        }
        return false;
    }

    private boolean checkDiagonal(char symbol) {
        // Bottom-left to top-right
        for (int i = 3; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS - 3; j++) {
                if (grid[i][j] == symbol && grid[i - 1][j + 1] == symbol && grid[i - 2][j + 2] == symbol && grid[i - 3][j + 3] == symbol) return true;
            }
        }

        // Top-left to bottom-right
        for (int i = 0; i < ROWS - 3; i++) {
            for (int j = 0; j < COLUMNS - 3; j++) {
                if (grid[i][j] == symbol && grid[i + 1][j + 1] == symbol && grid[i + 2][j + 2] == symbol && grid[i + 3][j + 3] == symbol) return true;
            }
        }

        return false;
    }
}
