public class Solution {
    public int[] countBits(int num) {
        int[] ans= new int[num+1];
        ans[0]=0;
        int powernumber=1;
        int pointer=1;
        for(int i=1;i<ans.length;i++)
        {
            if(i==powernumber)
            {
                ans[i]=1;
                powernumber=powernumber<<1;
                pointer=1;
            }
            else
                ans[i]=1+ans[pointer++];
        }
        return ans;
    }
}