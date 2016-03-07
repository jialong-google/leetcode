class Solution {
public:
    bool containsNearbyDuplicate(vector<int>& nums, int k) {
        int len=nums.size();
        unordered_map<int , int > has;
        for(int i=0;i<len;i++)
        {
            if(has.find(nums[i])!=has.end() && i-has[nums[i]]<=k)
                return true;
            has[nums[i]]=i;
        }
        return false;
    }
};