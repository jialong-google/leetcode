class Solution {
public:
    int maximumGap(vector<int>& nums) {
        int len=nums.size();
        if(len<2)
            return 0;
        int big=nums[0];
        int small=nums[0];
        
        for(int i=0;i<len;i++)
        {
            big=max(big,nums[i]);
            small=min(small,nums[i]);
        }
        if(big==small)
            return 0;
        int upper[len+1];
        int lower[len+1];
        for(int i=0;i<len+1;i++){
            upper[i]=INT_MIN;
            lower[i]=INT_MAX;
        }
        double num_bin_1=double((len-1)/(double)(big-small));//here is very tricky. when converting int to double . you should pay more attention and double check!
        for(int i=0;i<len;i++)
        {
            int index=(int)((nums[i]-small)*num_bin_1);
            upper[index]=max(upper[index],nums[i]);
            lower[index]=min(lower[index],nums[i]);
        }
        int l=small;
        int r=upper[0];
        int gap=r-l;
        for(int i=0;i<len+1;i++){//and here！！！
            if(lower[i]==INT_MAX)
                continue;
            r=lower[i];
            gap=max(r-l,gap);
            l=upper[i];
        }
        return gap;
    }
};

