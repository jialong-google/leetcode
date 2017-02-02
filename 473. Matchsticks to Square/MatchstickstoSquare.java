public class Solution {
    private boolean res = false;
    public boolean makesquare(int[] nums) {
        if(nums == null || nums.length <= 3)
            return false;
        int suppose = 0;
        for(int num : nums)
            suppose += num;
        if(suppose % 4 != 0)
            return false;
        helper(nums, 0, suppose / 4, 0, 0);
        return res;
    }
    private void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void helper(int[] nums, int depth, int exp, int add, int times)
    {
        if(res == true || add > exp)
            return;
        if(add == exp) 
        {
            times ++;
            add = 0;
            if(times == 4)
            {
                res = true;
                return ;
            }
        }
        Set<Integer> set = new HashSet<Integer>();
        for(int i = depth; i < nums.length; i++)
        {
            if(set.add(nums[i]))
            {
                swap(nums, i, depth);
                helper(nums, depth + 1, exp, add + nums[depth], times);
                swap(nums, i, depth);
            }
        }
    }
}