public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return false;
        return helper(nums, 0 , nums.length - 1, target);
    }
    public boolean helper(int[] nums, int begin, int end, int target)
    {
        if(begin > end)
            return false;
        if(nums[begin] == target || nums[end] == target)
            return true;
        int median = begin + (end - begin) / 2;
        if(nums[median] > nums[begin])
        {
            if(nums[median] >= target && nums[begin] <= target)
            {
                return helper(nums, begin, median, target);
            }
            else
            {
                return helper(nums, median + 1, end, target);
            }
        }
        else if(nums[median] < nums[begin])
        {
            if(nums[median] <= target && nums[end] >= target)
            {
                return helper(nums, median, end, target);
            }
            else
            {
                return helper(nums, begin, median - 1, target);
            }
        }
        else //if(nums[median] == nums[begin])
        {
            if(nums[median] == target)
                return true;
            else
            {
                return helper(nums, begin, median - 1, target) ||helper(nums, median + 1, end, target);
            }
        }
    }
}