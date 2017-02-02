public class Solution {
    private int[] dx = new int[]{0, 0, 1, -1};
    private int[] dy = new int[]{1, -1, 0, 0};
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return 0;
        int[][] mem = new int[matrix.length][matrix[0].length];
        int max = 0;
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                max = Math.max(max, dfs(matrix, mem, i, j));
                //mem[i][j] = max;
            }
        }
        return max;
    }
    private int dfs(int[][] matrix, int[][] mem, int i, int j)
    {
        
        if(mem[i][j] != 0)
            return mem[i][j];
        //int res = 0;
        for(int k = 0; k < 4; k++)
        {
            int newi = i + dx[k];
            int newj = j + dy[k];
            if(newi < 0 || newi >= matrix.length || newj < 0 || newj >= matrix[0].length)
            {
                continue;
            }
            if(matrix[i][j] > matrix[newi][newj])
            {
                mem[i][j] = Math.max(mem[i][j], dfs(matrix, mem, newi, newj));
            }
        }
        return ++mem[i][j];
    }
}