class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int len=nums.size();
        vector<int> largearray(len);
        vector<int> smallarray(len);
        int max1;
        for(int i=0;i<len;i++)
        {
            if(i!=0)
            {
                largearray[i]=max(max(largearray[i-1]*nums[i],smallarray[i-1]*nums[i]),nums[i]);
                smallarray[i]=min(min(largearray[i-1]*nums[i],smallarray[i-1]*nums[i]),nums[i]);
                max1=max(largearray[i],max1);
            }
            else{
                largearray[i]=nums[i];
                smallarray[i]=nums[i];
                max1=nums[i];
            }
        }
        return max1;
    }
};