public class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        int len = prices.length;
        if(len / 2 <= k)
            return quickSolve(prices);
        int[][] dp = new int[k + 1][len];
        for(int i = 1; i < k + 1; i++)
        {
            int tempMax = -prices[0];
            for(int j = 1; j < len; j++)
            {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + tempMax);
                tempMax = Math.max(tempMax, dp[i - 1][j - 1] - prices[j]);
            }
        }
        return dp[k][len - 1];
    }
    private int quickSolve(int[] prices)
    {
        int res = 0;
        for(int i = 1; i < prices.length; i++)
        {
            res += Math.max(0, prices[i] - prices[i - 1]);
        }
        return res;
    }
}