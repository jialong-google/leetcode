class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        deque<int> window;
        vector<int> res;
        if(nums.empty() || k==0)
            return res;
        int len=nums.size();
        for(int i=0;i<len;i++)
        {
            //front not valid.
            while(!window.empty() && window.front()<=i-k)
                window.pop_front();
            if(window.empty() || nums[i]>nums[window.front()])
                window.push_front(i);
            else
            {
                //back is invalid. or below the back.
                while(!window.empty() && (window.back()>i || window.back()<=i-k) || nums[window.back()]<nums[i])
                    window.pop_back();
                window.push_back(i);
            }
            if(i>=k-1)
                res.push_back(nums[window.front()]);
        }
        return res;
    }
};