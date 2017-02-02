public class Solution {
    public int thirdMax(int[] nums) {
        Integer first_max = null;
        Integer second_max = null;
        Integer third_max = null;
        if(nums == null || nums.length == 0)
            return 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(first_max == null || first_max == nums[i])
            {
                first_max = nums[i];
            }
            else if(nums[i] > first_max)
            {
                third_max = second_max;
                second_max = first_max;
                first_max = nums[i];
            }
            else if(second_max == null || second_max == nums[i])
            {
                second_max = nums[i];
            }
            else if(nums[i] >= second_max)
            {
                third_max = second_max;
                second_max = nums[i];
            }
            else if(third_max == null || nums[i] >= third_max)
            {
                third_max = nums[i];
            }
            
        }
        if(third_max == null)
            return first_max;
        return third_max;
    }
}