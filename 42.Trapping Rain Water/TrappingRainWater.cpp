class Solution {
public:
    int trap(vector<int>& height) {
        int n=height.size();
        int left(0),water(0),level(0);//the height of water.
        int right=n-1;
        
        while(left<right)
        {
            if(height[left]<height[right])
            {
                level=max(height[left],level);
                water+=level-height[left++];
            }
            else{
                level=max(height[right],level);
                water+=level-height[right--];
            }
        }
        return water;
    }
};
