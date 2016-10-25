public class Solution {
    public int combinationSum4(int[] nums, int target) {
        if(nums == null)
            return 0;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 0; i < target; i++)
        {
            for(int num : nums)
            {
                if(num + i <= target)
                {
                    dp[num + i] += dp[i];
                }
            }
        }
        return dp[target];
    }
}