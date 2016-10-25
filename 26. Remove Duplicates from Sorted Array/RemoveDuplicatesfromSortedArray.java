public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int slow = 0;
        int fast = 0;
        while(fast < nums.length)
        {
            if(nums[fast] == nums[slow])
            {
                fast ++;
            }
            else
            {
                nums[++slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}