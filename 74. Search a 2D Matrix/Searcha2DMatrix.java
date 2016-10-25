public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return false;
        int row = matrix.length;
        int col = matrix[0].length;
        
        int begin = 0;
        int end = row * col - 1;
        
        while(begin <= end)
        {
            int mid = begin + (end - begin) / 2;
            int mid_row = mid / col;
            int mid_col = mid % col;
            if(target == matrix[mid_row][mid_col])
            {
                return true;
            }
            else if(target < matrix[mid_row][mid_col])
            {
                end = mid - 1;
            }
            else
            {
                begin = mid + 1;
            }
        }
        return false;
        
    }
}