public class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int begin = 0;
        int end = nums.length - 1;
        while(begin < end - 1)
        {
            int medium = begin +(end - begin) / 2;
            //int m = nums[medium];
            if(nums[medium] > nums[medium + 1])
            {
                end = medium;
            }
            else
            {
                begin = medium + 1;
            }
        }
        if(nums[begin] < nums[end])
        {
            return end;
        }
        else
        {
            return begin;
        }
    }
}