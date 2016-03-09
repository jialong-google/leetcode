class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if not grid or not grid[0]:
            return 0
        self.m=len(grid)
        self.n=len(grid[0])
        ans=0
        for i in range(self.m):
            for j in range(self.n):
                if grid[i][j]=='1':
                    ans+=1
                    self.bfs(i,j,grid)
        return ans
    def bfs(self,i,j,grid):
        grid[i][j]='0'
        if(i+1<self.m and grid[i+1][j]=='1'):
            self.bfs(i+1,j,grid)
        if(i-1>=0 and grid[i-1][j]=='1'):
            self.bfs(i-1,j,grid)
        if(j+1<self.n and grid[i][j+1]=='1'):
            self.bfs(i,j+1,grid)
        if(j-1>=0 and grid[i][j-1]=='1'):
            self.bfs(i,j-1,grid)