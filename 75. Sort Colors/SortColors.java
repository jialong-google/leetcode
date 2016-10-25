public class Solution {
    private void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void sortColors(int[] nums) {
        if(nums == null  || nums.length  == 0)
        {
            return ;
        }
        int red = 0;
        //while(red < nums.length && nums[red] == 0)
        //{
        //    red++;
        //}
        //if(red == nums.length)
        //    return ;
        
        int blue = nums.length - 1;
        //while(blue >= 0 && nums[blue] ==2)
        //{
        //    blue--;
        //}
        //if(blue < red)
        //    return ;
        int white = blue;
        while(red <= white && red <= blue)
        {
            if(nums[red] == 0)
            {
                red++;
            }
            else if(nums[red] == 1)
            {
                swap(nums, red, white);
                white --;
            }
            else if(nums[red] == 2)
            {
                swap(nums, red, blue);
                blue --;
            }
            //very important...
            if(blue < white)
            {
                white = blue;
            }
        }
        return ;
    }
}