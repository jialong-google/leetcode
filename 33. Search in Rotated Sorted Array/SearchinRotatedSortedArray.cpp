class Solution {
public:
    int search(vector<int>& nums, int target) {
        if(nums.size()==0)
            return -1;
        int l=0;
        int r=nums.size()-1;
        while(l<r-1){
            int m=(l+r)/2;
            if(target==nums[m])
                return m;
            if(target==nums[l])
                return l;
            if(nums[r]==target)
                return r;
            if(target>nums[l] && target<nums[m])//nums[l]<nums[m]
                r=m;
            else if(target<nums[l] && target>nums[m])//nums[l]>nums[m]
                l=m;
            else if(target<nums[l] && target<nums[m] &&nums[l]<nums[m])
                l=m;
            else if(target<nums[l] && target<nums[m] &&nums[l]>nums[m])
                r=m;
            else if(target>nums[l] && target>nums[m] &&nums[l]>nums[m])
                r=m;
            else if(target>nums[l] && target>nums[m] &&nums[l]<nums[m])
                l=m;    
        }
        if(nums[l]==target)
            return l;
        if(nums[r]==target)
            return r;
        return -1;
        
    }
};