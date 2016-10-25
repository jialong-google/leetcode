public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        int one = 0;
        int two = 0;
        for(int i = 0; i < nums.length - 1; i++)
        {
            if(i % 2 == 0)
            {
                one += nums[i];
                one = Math.max(one, two);
            }
            else
            {
                two += nums[i];
                two = Math.max(one, two);
            }
        }
        int global = Math.max(one, two);
        one = 0;
        two = 0;
        for(int i = 1; i < nums.length; i++)
        {
            if(i % 2 == 0)
            {
                one += nums[i];
                one = Math.max(one, two);
            }
            else
            {
                two += nums[i];
                two = Math.max(one, two);
            }
        }
        return Math.max(Math.max(one, two), global);
    }
}