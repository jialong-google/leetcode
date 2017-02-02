public class Solution {
    public int minPatches(int[] nums, int n) {
        long max = 0;
        int count = 0;
        for(int i = 0; max < n;)
        {
            if( i >= nums.length || max < nums[i] - 1)
            {
                max += max + 1;
                count ++;
            }
            else
            {
                max += nums[i];
                i ++;
            }
        }
        return count;
    }
}