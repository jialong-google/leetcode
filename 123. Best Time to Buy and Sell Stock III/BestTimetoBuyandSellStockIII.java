public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        int res = 0;
        int[] pre = new int[prices.length];
        int[] suf = new int[prices.length];
        int min = prices[0];
        int max = prices[prices.length - 1];
        for(int i = 1; i < prices.length; i++)
        {
            pre[i] = Math.max(prices[i] - min, pre[i - 1]);
            min = Math.min(min, prices[i]);
        }
        for(int i = prices.length - 2; i >= 0; i--)
        {
            suf[i] = Math.max(max - prices[i], suf[i + 1]);
            max = Math.max(max, prices[i]);
        }
        for(int i = 0; i < prices.length; i++)
        {
            res = Math.max(res, pre[i] + suf[i]);
        }
        return res;
    }
}