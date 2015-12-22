class Solution {
public:
    int firstMissingPositive(vector<int>& nums) {
        int len= nums.size();
        int i=0;
        while(i<len){
            if(nums[i]!=i+1 && nums[i]>=1 && nums[i]<len &&nums[i]!=nums[nums[i]-1])//<len or <=len are both ok.
                swap(nums[i],nums[nums[i]-1]);//swap.
            else
                i++;
        }
        for(int j=0;j<len;j++)
            if(nums[j]!=j+1)
                return j+1;
        return len+1;//tricky!
    }
    
};