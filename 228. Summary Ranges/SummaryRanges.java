public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans=new ArrayList<String>();
        if(nums.length==0)
            return ans;
        int begin=-1;
        int prev=-1;
        for(int i=0;i<nums.length;i++)
        {
            if(begin==-1)
            {
                begin=i;
                prev=i;
            }
            else
            {
                if(nums[prev]+1==nums[i])
                    prev++;
                else{
                    if(prev==begin)
                        ans.add(nums[begin]+"");
                    else
                        ans.add(nums[begin]+"->"+nums[prev]);
                    begin=-1;
                    prev=-1;
                    i--;
                }
            }
        }
        if(begin!=-1)
        {
            if(prev==begin)
                ans.add(nums[begin]+"");
            else
                ans.add(nums[begin]+"->"+nums[prev]);
        }
        return ans;
    }
}