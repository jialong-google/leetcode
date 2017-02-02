public class Solution {
    private int[] solve(int[] nums, int k)
    {
        int[] res = new int[k];
        int len = 0;
        for(int i = 0; i < nums.length; i++)
        {
            while(len > 0 && len + nums.length - i > k && res[len - 1] < nums[i])
            {
                len --;
            }
            if(len < k)
                res[len ++] = nums[i];
        }
        return res;
    }
    private int[] combine(int[] nums1, int[] nums2)
    {
        int[] res = new int[nums1.length + nums2.length];
        int p1 = 0;
        int p2 = 0;
        for(int i = 0; i < res.length; i++)
        {
            if(compare(nums1, nums2, p1, p2))
            {
                res[i] = nums2[p2++];
            }
            else
            {
                res[i] = nums1[p1++];
            }
        }
        return res;
    }
    private boolean compare(int[] nums1, int[] nums2, int p1, int p2) // false means 1 > 2
    {
        for(; p1 < nums1.length && p2 < nums2.length; p1++, p2++)
        {
            if(nums1[p1] > nums2[p2])
                return false;
            if(nums1[p1] < nums2[p2])
                return true;
        }
        return p1 == nums1.length;
    }
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] global_res = null;
        int num1 = Math.min(nums1.length, k);
        for(int i = Math.max(k - nums2.length, 0); i <= num1; i++)
        {
            int[] res1 = solve(nums1, i);
            int[] res2 = solve(nums2, k - i);
            int[] res = combine(res1, res2);
            if(global_res == null || compare(res, global_res, 0, 0) == false)
            {
                global_res = res;
            }
        }
        return global_res;
    }
}