public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0)
            return 0;
        int num = envelopes.length;
        if(envelopes[0] == null || envelopes[0].length == 0)
            return 0;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2)
            {
                if(o1[0] == o2[0])  return 0;
                if(o1[0] < o2[0])
                    return -1;
                return 1;
            }
        });
        int[] dp = new int[num];
        dp[0] = 1;
        int max = 1;
        for(int i = 1; i < num; i++)
        {
            int m = 0;
            for(int j = 0; j < i; j++)
            {
                if(envelopes[i][1] > envelopes[j][1] && envelopes[i][0] != envelopes[j][0])
                {
                    m = Math.max(dp[j], m);
                }
            }
            dp[i] = m + 1;
            max = Math.max(m + 1, max);
        }
        return max;
    }
}