public class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0)
            return 0;
        int last = height.length - 1;
        int begin = 0;
        int level = Math.min(height[last], height[begin]);
        int water = 0;
        while( begin < last)
        {
            if(height[last] <= height[begin])
            {
                water += Math.max(0, level - height[last]);
                level = Math.max(height[last], level);
                last--;
            }
            else
            {
                water += Math.max(0, level - height[begin]);
                level = Math.max(height[begin], level);
                begin++;
            }
        }
        return water;
    }
}