public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        int[] cooldown = new int[prices.length];
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        for(int i = 1; i < prices.length; i++)
        {
            buy[i] = Math.max(buy[i - 1], cooldown[i - 1] - prices[i]);
            sell[i] = buy[i - 1] + prices[i];
            cooldown[i] = Math.max(sell[i - 1], cooldown[i - 1]);
        }
        return Math.max(cooldown[prices.length - 1], sell[prices.length - 1]);
    }
}