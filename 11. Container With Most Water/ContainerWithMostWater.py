class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        first=0
        last=len(height)-1
        ans=0
        while first<last:
            ans=max(min(height[first],height[last])*(last-first),ans)
            if height[first]<height[last]:
                first+=1
            else:
                last-=1
        return ans
            