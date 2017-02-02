public class Solution {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0] == null || costs[0].length == 0)
            return 0;
        int n = costs.length;
        int k = costs[0].length;
        Integer min1 = null;
        Integer min2 = null;
        Integer last1 = null;
        Integer last2 = null;
        for(int i = 0; i < n; i++)
        {
            last1 = min1;
            last2 = min2;
            min1 = null;
            min2 = null;
            for(int j = 0; j < k; j++)
            {
                if(i != 0)
                    if(j == last1)
                    {
                        costs[i][j] += costs[i - 1][last2];
                    }
                    else
                    {
                        costs[i][j] += costs[i - 1][last1];
                    }
                //this part is very classic.
                if(min1 == null || costs[i][j] < costs[i][min1])
                {
                    min2 = min1;
                    min1 = j;
                }
                else if(min2 == null || costs[i][j] < costs[i][min2])
                {
                    min2 = j;
                }
            }
        }
        return costs[n - 1][min1];
    }
}