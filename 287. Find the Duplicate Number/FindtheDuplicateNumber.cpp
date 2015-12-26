class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        int r=nums[nums[0]];
        int h=nums[0];
        while(h!=r)
        {
            r=nums[nums[r]];
            h=nums[h];
        }
        int finder=0;//here if nums[0], the slow will never meet with finder.
        while(finder!=h)
        {
            finder=nums[finder];
            h=nums[h];
        }
        return finder;
    }
};