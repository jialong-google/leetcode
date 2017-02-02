public class Solution {
    private int getMin(List<Integer> current)
    {
        Collections.sort(current);
        int i = 0;
        int j = current.size() - 1;
        int res = 0;
        while(i < j)
        {
            res += current.get(j--) -current.get(i ++);
        }
        return res;
    }
    public int minTotalDistance(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        List<Integer> X = new ArrayList<Integer>();
        List<Integer> Y = new ArrayList<Integer>();
        int count = 0;
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 1)
                {
                    count ++;
                    X.add(i);
                    Y.add(j);
                }
            }
        }
        return getMin(X) + getMin(Y);
    }
}