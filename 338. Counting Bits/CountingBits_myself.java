public class Solution {
    public int[] countBits(int num) {
        int[] ans= new int[num+1];
        ans[0]=0;
        int the_prev_first_one=0;
        for(int i=1;i<ans.length;i++)
        {
            int first_one_now=i&-i;
            if(first_one_now==i)
            {
                ans[i]=1;
                continue;
            }
            if(first_one_now>the_prev_first_one &&the_prev_first_one!=0)
            {
                ans[i]=ans[i-1]-(int)((Math.log(first_one_now/the_prev_first_one))/Math.log(2))+1;
            }
            else
            {
                ans[i]=ans[i-1]+1;
            }
            the_prev_first_one=first_one_now;
        }
        return ans;
    }
}