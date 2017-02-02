public class Solution {
    private int[] rows;
    private int[] cols;
    private int[] inner;
    public void solveSudoku(char[][] board) {
        rows = new int[9];
        cols = new int[9];
        inner = new int[9];
        preprocessing(board, rows, cols, inner);
        helper(board, 0, 0);
        return ;
    }
    private void preprocessing(char[][] board, int[] rows, int[] cols, int[] inner)
    {
        for(int i = 0 ; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                char current = board[i][j];
                if(current != '.')
                {
                    rows[i] |= (1<< (current - '0'));
                    cols[j] |= (1<< (current - '0'));
                    inner[i / 3 * 3 + j / 3] |= (1 << (current - '0'));
                }
            }
        }
        for(int i = 0; i < 9; i++)
        {
            rows[i] = ~rows[i];
            cols[i] = ~cols[i];
            inner[i] = ~inner[i];
        }
    }
    private boolean helper(char[][] board, int i, int j)
    {
        if(i == 9 && j == 0)
        {
            return true;
        }
        if(board[i][j] == '.')
        {
            int temp = rows[i] & cols[j] & inner[i / 3 * 3 + j / 3];
            for(int ii = 1; ii <= 9; ii++)
            {
                if((temp & (1<< ii)) != 0)
                {
                    board[i][j] = (char)('0' + ii);
                    rows[i] &= ~(1 << ii);
                    cols[j] &= ~(1 << ii);
                    inner[i / 3 * 3 + j / 3] &= ~(1 << ii);
                    //temp &= ~(1 << ii);
                    boolean res = false;
                    if(j < 8)
                        res = helper(board, i, j + 1);
                    else
                        res = helper(board, i + 1, 0);
                    if(res == false)
                    {
                        board[i][j] = '.';
                        //temp |= (1 << ii);
                        rows[i] |= (1 << ii);
                        cols[j] |= (1 << ii);
                        inner[i / 3 * 3 + j / 3] |= (1 << ii);
                    }
                    else
                        return true;
                }
            }
            return false;// this step is very important. 
            //it can guarantee that the current step should be put in a number if it is a '.'.
        }
        boolean res = false;
        if(j < 8)
            res = helper(board, i, j + 1);
        else
            res = helper(board, i + 1, 0);
        return res;
    }
}