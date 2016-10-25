public class Solution {
    private int res;
    public int numIslands(char[][] grid) {
        //corner case.
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return 0;
        //a visited grid which has the same size as the input, indicates
        //if we had visited the according grid.
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        //resolution.
        res = 0;
        //check on each individual island.
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(visited[i][j] == false)
                {
                    if(helper(grid, visited, i, j))
                        res ++;
                }
            }
        }
        return res;
    }
    //it returns if the dfs result of the current location should be counted.
    public boolean helper(char[][] grid, boolean[][] visited, int currentRow, int currentCol )
    {
        //if the current location has been visited or it is sea.
        //return false to indicate that we should not take it into consideration.
        if(visited[currentRow][currentCol] == true || grid[currentRow][currentCol] == '0')
            return false;
        //else assign visited true.
        visited[currentRow][currentCol] = true;
        //do dfs flooding, so that each neighbor will be marked as visited.
        if(currentRow + 1 < visited.length)
        {
            helper(grid, visited, currentRow + 1, currentCol);
        }
        if(currentRow - 1 >= 0)
        {
            helper(grid, visited, currentRow - 1, currentCol);
        }
        if(currentCol + 1 < visited[0].length)
        {
            helper(grid, visited, currentRow, currentCol + 1);
        }
        if(currentCol - 1 >= 0)
        {
            helper(grid, visited, currentRow, currentCol - 1);
        }
        //return true to indicate that we find island!
        return true;
    }
}