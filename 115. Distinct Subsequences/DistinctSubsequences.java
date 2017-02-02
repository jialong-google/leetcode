public class Solution {
    public int numDistinct(String s, String t) {
        int m = t.length();
        int n = s.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i < n + 1; i++)
        {
            dp[0][i] = 1;
        }
        int pre = 0;
        for(int i = 1; i < m + 1; i++)
        {
            pre = 0;
            for(int j = 1; j < n + 1; j++)
            {
                if(s.charAt(j - 1) == t.charAt(i - 1))
                {
                    dp[i][j] = pre + dp[i - 1][j - 1];
                    pre = dp[i][j];
                }
                else
                {
                    dp[i][j] = pre;
                }
            }
        }
        return pre; 
    }
}