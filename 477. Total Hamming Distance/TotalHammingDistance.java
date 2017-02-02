public class Solution {
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        for(int i =0 ;i < 32; i++)
        {
            int bit = 0;
            for(int j = 0 ; j < nums.length ; j++)
            {
                bit += (nums[j] >> i) & 1;
            }
            res += (bit) *(nums.length - bit);
        }
        return res;
    }
}