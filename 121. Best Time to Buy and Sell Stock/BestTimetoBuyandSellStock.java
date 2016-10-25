public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++)
        {
            profit = Math.max(prices[i] - min, profit);
            min = Math.min(prices[i], min);
        }
        return profit;
    }
}