public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int one = 0;// leap for one.
        int two = 0;// leap for two.
        int global = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(i % 2 == 0)
            {
                one += nums[i];
                one = Math.max(two, one);
            }
            else
            {
                two += nums[i];
                two = Math.max(one, two);
            }

        }
        return Math.max(one, two);
    }
}