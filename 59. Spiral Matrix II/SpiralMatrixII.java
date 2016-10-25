public class Solution {
    private int[][] res;
    public int[][] generateMatrix(int n) {
        if(n <= 0)
            return new int[0][0];
        res = new int[n][n];
        helper(0,1,n);
        return res;
    }
    private void helper(int level, int begin, int width)
    {
        if(level > width / 2 )
        {
            return;
        }
        if(level == width / 2 && width % 2 == 1)
        {
            res[level][level] = begin;
            return;
        }
        else
        {
            for(int i = level; i < width - level; i++)
            {
                res[level][i] = begin ++;
            }
            for(int i = level + 1; i < width - level; i ++)
            {
                res[i][width - level - 1] = begin ++;
            }
            for(int i = width - level - 2; i >= level; i--)
            {
                res[width - level - 1][i] = begin ++;
            }
            for(int i = width - level - 2; i >= level + 1; i--)
            {
                res[i][level] = begin++;
            }
            helper(level + 1, begin, width);
        }
    }
}