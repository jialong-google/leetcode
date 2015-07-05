class Solution {
public:
    int findMin(vector<int>& nums) {
        int j=nums.front();
        for(vector<int>::iterator i=nums.begin();i<nums.end();i++)
        {
            if(*i<j){
                j=*i;
            }
        }
        return j;
    }
};
