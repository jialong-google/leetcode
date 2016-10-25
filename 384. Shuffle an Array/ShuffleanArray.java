public class Solution {
    private int[] res;
    private int[] origin;
    public Solution(int[] nums) {
        origin = nums;
        res = new int[nums.length];
        for(int i = 0; i < nums.length; i ++)
        {
            res[i] = origin[i];
        }
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        for(int i = 0; i < origin.length; i ++)
        {
            res[i] = origin[i];
        }
        return res;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i = 0; i < res.length; i++)
        {
            swap(i, (int) (Math.random() * res.length));
        }
        return res;
    }
    private void swap(int i , int j)
    {
        if(i > res.length || j > res.length)
            return;
        int temp = res[i];
        res[i] = res[j];
        res[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */