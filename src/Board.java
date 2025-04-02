class Board {
    private char[][] grid;
    private final int ROWS = 6;
    private final int COLUMNS = 7;
    private final char EMPTY = '.';

    // Constructor: initialize empty board
    public Board() {
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

}
