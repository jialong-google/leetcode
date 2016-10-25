public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums == null || nums.length == 0)
            return new ArrayList<Integer>();
        int[] dp = new int[nums.length];
        int[] pre = new int[nums.length];
        Arrays.sort(nums);
        dp[0] = 1;
        pre[0] = -1;
        ArrayList<Integer> res = new ArrayList<Integer>();
        int max = 0;// record the tail~ who has the max value of subset.
        for(int i = 1; i < nums.length; i++)
        {
            int pr = -1;
            int global = 0;
            for(int j = 0; j < i; j++)
            {
                if(nums[i] % nums[j] == 0 && dp[j] >= dp[global])
                {
                    global = j;
                    pr = j;
                }
            }
            dp[i] = dp[global] + 1;
            pre[i] = pr;
            if(dp[i] > dp[max])
            {
                max = i;
            }
        }
        //backward, to pick up back the previous one individually.
        res.add(nums[max]);
        max = pre[max];
        while(max != -1)
        {
            res.add(nums[max]);
            max = pre[max];
        }
        return res;
    }
}