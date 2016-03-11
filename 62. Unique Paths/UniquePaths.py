class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        if m==0 or n==0:
            return 1
        dp=[[0 for i in range(n)] for j in range(m)]
        for i in range(m)[::-1]:
            for j in range(n)[::-1]:
                if i==m-1 and j==n-1:
                    dp[i][j]=1
                elif i==m-1:
                    dp[i][j]=dp[i][j+1]
                elif j==n-1:
                    dp[i][j]=dp[i+1][j]
                else:
                    dp[i][j]=dp[i+1][j]+dp[i][j+1]
        return dp[0][0]