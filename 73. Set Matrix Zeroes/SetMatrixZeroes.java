public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return ;
        int row = matrix.length;
        int col = matrix[0].length;
        boolean erase_row = false;
        boolean erase_col = false;
        for(int i = 0; i < col ; i++)
        {
            if(matrix[0][i] == 0)
            {
                erase_row = true;
                break;
            }
        }
        for(int i = 0; i < row; i ++)
        {
            if(matrix[i][0] == 0)
            {
                erase_col = true;
                break;
            }
        }
        for(int i =1; i < row; i++)
        {
            for(int j = 1; j < col; j++)
            {
                if(matrix[i][j] == 0)
                {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1; i < row; i++)
        {
            if(matrix[i][0] == 0)
            {
                for(int j = 1; j < col; j++)
                {
                    matrix[i][j] = 0;
                }
            }
        }
        for(int j = 1; j < col; j++)
        {
            if(matrix[0][j] == 0)
            {
                for(int i = 1; i < row; i++)
                {
                    matrix[i][j] = 0;
                }
            }
        }
        if(erase_row)
        {
            for(int i = 0; i < col; i++)
            {
                matrix[0][i] = 0;
            }
        }
        if(erase_col)
        {
            for(int i = 0; i < row; i++)
            {
                matrix[i][0] = 0;
            }
        }
    }
}