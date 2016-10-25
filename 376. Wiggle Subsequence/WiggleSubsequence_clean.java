public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int len1 = 1;
        int p = 1;
        int q = 1;
        for(int i = 1; i < nums.length ; i++)
        {
            int diff = nums[i] - nums[i - 1];
            if(diff  > 0)
                p = q + 1;
            if(diff < 0)
                q = p + 1;
        }
        return Math.max(p, q);
    }
}