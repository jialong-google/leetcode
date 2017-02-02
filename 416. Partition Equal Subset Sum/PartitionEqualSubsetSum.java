public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums)
        {
            sum += i;
        }
        if(sum % 2 != 0)
            return false;
        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;
        for(int i = 0; i < nums.length; i++)
        {
            for(int j = dp.length - 1; j >= 0; j--)
            {
                if(dp[j] && j + nums[i] < dp.length)
                {
                    dp[j + nums[i]] = true;
                }
            }
        }
        return dp[dp.length - 1];
    }
}