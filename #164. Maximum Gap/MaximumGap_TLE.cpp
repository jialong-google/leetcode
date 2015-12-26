class Solution {
public:
    int maximumGap(vector<int>& nums) {
        int len=nums.size();
        unordered_map<int,bool> bin;
        int mx=-999;
        int ms=999;
        for(int i=0;i<len;i++)
        {    
            if(nums[i]>mx)
                mx=nums[i];
            if(nums[i]<ms)
                ms=nums[i];
            bin[nums[i]]=true;
        }
        int mp=0;
        int p=0;
        for(int i=ms;i<mx;i++)
        {   
            p++;
            if(bin[i]==true && mp<p)
            {
                mp=p;
            }
        }
        if(mp<p+1)
            mp=p+1;
        return mp;
        
    }
};