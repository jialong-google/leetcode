class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        if not matrix or not matrix[0]:
            return 0
        else:
            m=len(matrix)
            n=len(matrix[0])
        dp=[[ 0 for i in range(n)]for j in range(m)]
        maxElement=int(matrix[0][0])
        for i in range(n):
            dp[0][i]=int(matrix[0][i])
            maxElement=max(dp[0][i],maxElement)
        for j in range(m):
            dp[j][0]=int(matrix[j][0])
            maxElement=max(dp[j][0],maxElement)
        for i in range(1,m):
            for j in range(1,n):
                if matrix[i][j]=='1':
                    dp[i][j]=min(dp[i-1][j-1],min(dp[i][j-1],dp[i-1][j]))+1
                maxElement=max(dp[i][j],maxElement)
        return maxElement*maxElement