public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length <= 2 )
            return nums.length;
        int slow = 1;
        int fast = 2;
        while(fast < nums.length)
        {
            if(nums[slow - 1] != nums[fast])
            {
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}