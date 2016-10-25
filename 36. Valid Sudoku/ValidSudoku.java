public class Solution {
    public boolean isValidSudoku(char[][] board) {
        //validate row
        for(int i = 0; i < board.length; i++)
        {
            int temp = 0;
            for(int j = 0; j < board[i].length;j++)
            {
                if(board[i][j] == '.')
                    continue;
                int cur = board[i][j] - '0';
                if((temp & (0x1 << cur) )== 0)
                {
                    temp |= (0x1 << cur);
                }
                else
                {
                    return false;
                }
            }
        }
        //validate col
        for(int i = 0; i < board[0].length; i++)
        {
            int temp = 0;
            for(int j = 0; j < board.length;j++)
            {
                if(board[j][i] == '.')
                    continue;
                int cur = board[j][i] - '0';
                if((temp & (0x1 << cur)) == 0)
                {
                    temp |= (0x1 << cur);
                }
                else
                {
                    return false;
                }
            }
        }
        //validate 9.
        for(int i = 0; i < board.length; i+= 3)
        {
            for(int j = 0; j < board[0].length; j += 3)
            {
                int temp = 0;
                for(int k = 0; k < 9; k++)
                {
                    if(board[i + k / 3][j + k % 3] == '.')
                    continue;
                    int cur = board[i + k / 3][j + k % 3] - '0';
                    if((temp & (0x1 << cur)) == 0)
                    {
                        temp |= (0x1 << cur);
                    }
                    else
                    {
                        return false;
                    }
                }
            }
        }
        return true;
        
    }
}