public class Solution {
    public void reverse(int[] nums,int i,int j)
    {
        for(;i<j;i++,j--)
        {
            int tmp=nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;
        }
    }
    public void nextPermutation(int[] nums) {
        int suddenfault=-1;
        int exchange=-1;
        for(int i=nums.length-1;i>=1;i--)
        {
            if(nums[i-1]<nums[i])
            {
                suddenfault=i-1;
                break;
            }
        }
        if(suddenfault!=-1)
        {
            for(int i=nums.length-1;i>suddenfault;i--)
            {
                if(nums[i]>nums[suddenfault])
                {
                    exchange=i;
                    break;
                }
            }
            int tmp=nums[exchange];
            nums[exchange]=nums[suddenfault];
            nums[suddenfault]=tmp;
        }
        //System.out.println(suddenfault+1 +","+ (nums.length-1));
        reverse(nums,suddenfault+1,nums.length-1);
    }
}