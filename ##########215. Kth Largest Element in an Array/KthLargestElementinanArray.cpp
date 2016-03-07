class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        multiset<int> s;
        int len=nums.size();
        for(int i=0;i<len;i++)
        {
            s.insert(nums[i]);
        }
        for(int i=0;i<k-1;i++)
        {
            s.erase(s.find(*s.rbegin()));
        }
        return *s.rbegin();
    }
};