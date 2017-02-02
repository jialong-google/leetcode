public class Solution {
    public int splitArray(int[] nums, int m) {
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        long right = 0;
        long left = 0;
        for(int i = 0; i < nums.length; i++)
        {
            left = Math.max(nums[i], left);
            right += nums[i];
        }
        if(m == 1)
            return (int) right;
        if(m == nums.length)
            return (int) left;
        while(left < right)
        {
            long mid = left + (right - left) / 2;
            //System.out.println(mid);
            if(valid(mid, nums, m))
            {
                right = mid;
            }
            else
            {
                left = mid + 1;
            }
        }
        return (int)left;
    }
    private boolean valid(long mid, int[] nums, int m)
    {
        int count = 1;
        long acc = 0;
        for(int i = 0; i < nums.length; i++)
        {
            acc += nums[i];
            if(acc > mid)
            {
                count++;
                acc = nums[i];
            }
            if(count > m)
            {
                return false;
            }
        }
        return true;
    }
}