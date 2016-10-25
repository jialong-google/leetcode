public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int y = col - 1;
        for(int x = 0; x < row ; x++)
        {
            while(y > 0 && matrix[x][y] > target)
            {
                y --;
            }
            if(matrix[x][y] == target)
                return true;
        }
        return false;
    }
}