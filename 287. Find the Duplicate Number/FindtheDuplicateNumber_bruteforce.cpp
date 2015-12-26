class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        int len=nums.size();
        for(int i=0;i<len;i++){
            int ii=nums[i];
            for(int j=0;j<len;j++){
                if(nums[j]==ii && i!=j)
                    return nums[j];
            }
        }
    }
};