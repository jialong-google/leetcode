public class Solution {
    public int combinationSum4(int[] nums, int target) {
        if(nums == null)
            return 0;
        int[] dp = new int[target + 1];
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++)
        {
            set.add(nums[i]);
        }
        dp[0] = 1;
        for(int i = 1; i < target + 1; i++)
        {
            for(int j = 0 ; j < i; j++)
            {
                if(set.contains(i - j))
                {
                    dp[i] += dp[j];
                }
            }
        }
        return dp[target];
    }
}