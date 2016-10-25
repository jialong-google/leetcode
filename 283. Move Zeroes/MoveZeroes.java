public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0)
            return ;
        int begin = 0;
        int end = 0;
        while(end < nums.length)
        {
            if(nums[end] != 0)
            {
                nums[begin ++] = nums[end];
            }
            end++;
        }
        while(begin < nums.length)
        {
            nums[begin++] = 0;
        }
        
        return ;
    }
}