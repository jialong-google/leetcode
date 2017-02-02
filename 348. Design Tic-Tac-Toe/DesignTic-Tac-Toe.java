public class TicTacToe {

    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int anti_diagonal;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        diagonal = 0;
        anti_diagonal = 0;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int adder = player == 1? 1: -1;
        int n = rows.length;
        rows[row] += adder;
        cols[col] += adder;
        if(row == col)
        {
            diagonal += adder;
        }
        if(row + col + 1== n)
        {
            anti_diagonal += adder;
        }
        
        if(Math.abs(rows[row] )== n || Math.abs(cols[col] )== n ||Math.abs(diagonal) == n || Math.abs(anti_diagonal) == n)
            return player;
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */