public class Solution {
    public int minMoves(int[] nums) {
        if(nums == null || nums.length == 1)
        {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++)
        {
            min = Math.min(nums[i], min);
        }
        int res = 0;
        for(int i = 0; i < nums.length; i++)
        {
            res += nums[i] - min;
        }
        //if(res % (nums.length -1) == 0)
        //if(nums.length % 2 != 0)
    //    {
      //      return (int)(res / (nums.length - 1));
        //}
        //else
        //{
            return res;
        //}
        
    }
}