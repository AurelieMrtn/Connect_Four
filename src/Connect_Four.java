public class Connect_Four {
    public static void main(String[] args) {
        Board board = new Board();

        board.drop(4, 'O');
        board.drop(2, 'X');
        board.drop(4, 'O');
        board.drop(4, 'O');
        board.drop(4, 'O');

        board.displayBoard();
        System.out.println(String.valueOf(board.checkWin('O')));
        System.out.printf(String.valueOf(board.checkWin('X')));

    }
}