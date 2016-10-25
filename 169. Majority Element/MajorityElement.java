public class Solution {
    public int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int current = nums[0];
        int counter = 1;
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] == current)
            {
                counter++;
            }
            else if(counter > 1)
            {
                counter--;
            }
            else
            {
                counter = 1;
                current = nums[i]; 
            }
        }
        return current;
    }
}