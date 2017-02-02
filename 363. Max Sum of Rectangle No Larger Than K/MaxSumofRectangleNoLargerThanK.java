public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0)
            return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int m = Math.min(row, col);
        int n = Math.max(row, col);
        int res = Integer.MIN_VALUE;
        boolean colBig = (col > row);
        for(int i = 0; i < m; i++)
        {
            int[] dp = new int[n];
            
            for(int j = i; j >= 0; j--)
            {
                int val = 0;
                TreeSet<Integer> set = new TreeSet<Integer>();
                set.add(0);
                for(int kk = 0; kk < n; kk++)
                {
                    dp[kk] += (colBig? matrix[j][kk] : matrix[kk][j]);
                    val += dp[kk];//!!!!!
                    Integer subres = set.ceiling(val - k);//!!!!!
                    if(subres != null)
                    {
                        res = Math.max(val - subres, res);
                    }
                    set.add(val);
                }
            }
        }
        return res;
    }
}