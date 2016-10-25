public class Solution {
    public void insert(List<Integer> global, int target)
    {
        //insert to the place is first larger than target.
        int begin = 0;
        int end = global.size() - 1;
        while(begin < end - 1)
        {
            int medium = begin + (end - begin) / 2;
            int medium_num = global.get(medium);
            if(medium_num < target)
            {
                begin = medium;
            }
            else// medium_num > target
            {
                end = medium;
            }
        }
        if(global.get(begin) > target)
            global.set(begin, target);
        else
            global.set(end, target);
    }
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++)
        {
            int cur = nums[i];
            if(res.isEmpty() || cur > res.get(res.size() - 1))
            {
                res.add(cur);
            }
            else
                insert(res, cur);
        }
        return res.size();
    }
}