public class Solution {
    private int res;
    public int islandPerimeter(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return 0;
        res = 0;
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 1)
                {
                    dfs(grid, i, j);
                    break;
                }
            }
        }
        return res;
    }
    private void dfs(int[][] grid, int i, int j)
    {
        
        if(i < 0 || i >= grid.length)
        {
            return;
        }
        if(j < 0 || j >= grid[0].length)
        {
            return;
        }
        if(grid[i][j] == 0 || grid[i][j] == 2)
            return ;
        else
            grid[i][j] = 2;
        
        if(i - 1 < 0 || grid[i - 1][j] == 0)
        {
            res ++;
        }
        else
        {
            dfs(grid, i - 1, j);
        }
        
        if(i + 1 >= grid.length || grid[i + 1][j] == 0)
        {
            res ++;
        }
        else
        {
            dfs(grid, i + 1, j);
        }
        
        if(j - 1 < 0 || grid[i][j - 1] == 0)
        {
            res ++;
        }
        else
        {
            dfs(grid, i, j - 1);
        }
        if(j + 1 >= grid[0].length || grid[i][j + 1] == 0)
        {
            res ++;
        }
        else
        {
            dfs(grid, i, j+1);
        }
    }
}