public class Solution {
    //0: from a dead cell to a dead cell
    //1: from a live cell to a live cell
    //2: from a live cell to a dead cell
    //3: from a dead cell to a live cell
    private int[][] step = {{1,1},{-1,-1},{-1,1},{-1,0},{1,-1},{1,0},{0,1},{0,-1}};
    public int count(int i, int j, int[][] board)
    {
        int counter = 0;
        for(int p = 0; p < step.length; p++)
        {
            if(i+step[p][0] < board.length && i+step[p][0] >=0 && j +step[p][1] < board[0].length && j + step[p][1] >= 0)
            {
                if(board[i + step[p][0]][j + step[p][1]] == 1 || board[i + step[p][0]][j + step[p][1]] == 2)
                {
                    counter ++;
                }
            }
        }
        return counter;
    }
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0)
            return ;
        for(int i = 0; i < board.length ; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                int neighbor = count(i,j, board);
                if(board[i][j] == 1)
                {
                    if(neighbor < 2 || neighbor > 3)
                    {
                        board[i][j] = 2;
                    }
                }
                else
                {
                    if( neighbor == 3)
                    {
                        board[i][j] = 3;
                    }
                }
            }
        }
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if(board[i][j] == 2)
                {
                    board[i][j] = 0;
                }
                else if(board[i][j] == 3)
                {
                    board[i][j] = 1;
                }
            }
        }
    }
}