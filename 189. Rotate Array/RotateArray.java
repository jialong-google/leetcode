public class Solution {
    public void rotate(int[] nums, int k) {
        if(k <= 0)
            return ;
        k = k % nums.length;
        if(k == 0)
            return ;
        int i = 0;
        int j = nums.length - k - 1;
        while(i < j)
        {
            swap(nums, i++, j--);
        }
        i = nums.length - k;
        j = nums.length - 1;
        while(i < j)
        {
            swap(nums, i++, j--);
        }
        i = 0;
        j = nums.length -1;
        while(i < j)
        {
            swap(nums, i++, j--);
        }
    }
    public void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}