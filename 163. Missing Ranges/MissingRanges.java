public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        if(nums == null || nums.length == 0)
        {
            if(lower == upper)
                res.add(lower + "");
            else
            {
                res.add(lower + "->" + upper);
            }
            return res;
        }
        Arrays.sort(nums);
        Integer begin = null;
        if(nums[0] != lower)
        {
            if(nums[0] == lower + 1)
            {
                res.add(lower + "");
            }
            else
            {
                res.add(lower + "->" + (nums[0] - 1));
            }
        }
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] == nums[i - 1] + 1 || nums[i] == nums[i - 1])
            {
                continue;
            }
            else if(nums[i - 1] + 1 == nums[i] - 1)
            {
                res.add((nums[i - 1] + 1) + "");
            }
            else
            {
                res.add((nums[i - 1] + 1) + "->" + (nums[i] - 1));
            }
        }
        int current = nums[nums.length - 1];
        if(current < upper)
        {
            if(upper == current + 1)
            {
                res.add(upper + "");
            }
            else
            {
                res.add((current + 1) + "->" + upper);
            }
        }
        return res;
    }
}