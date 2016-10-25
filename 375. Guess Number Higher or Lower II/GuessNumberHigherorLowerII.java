public class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][ n + 1];
        for(int i = n; i > 0; i--)
        {
            for(int j = i + 1; j < n + 1; j++)
            {
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i; k < j; k ++)
                {
                    dp[i][j] = Math.min(dp[i][j], k + Math.max(dp[i][k - 1], dp[k+ 1][j]));
                }
            }
        }
        return dp[1][n];
    }
}