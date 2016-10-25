public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int len1 = 1;
        boolean pos = true;
        for(int i = 1; i < nums.length ; i++)
        {
            int diff = nums[i] - nums[i - 1];
            if((diff > 0 && pos) ||(diff < 0 && !pos))
            {
                len1 ++;
                pos = !pos;
            }
        }
        int len2 = 1;
        pos = false;
        for(int i = 1; i < nums.length ; i++)
        {
            int diff = nums[i] - nums[i - 1];
            if((diff > 0 && pos) ||(diff < 0 && !pos))
            {
                len2 ++;
                pos = !pos;
            }
        }
        return Math.max(len1, len2);
    }
}