class Solution(object):
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        height=len(triangle)
        dp=[i for i in triangle[-1]]
        for row in range(len(triangle)-1)[::-1]:
            for col in range(len(triangle[row])):
                dp[col]= min(dp[col],dp[col+1])+triangle[row][col]
        return dp[0]