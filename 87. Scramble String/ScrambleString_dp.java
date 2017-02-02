public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1 == null && s2 == null)
            return true;
        if(s1 == null || s2 == null)
            return false;
        if(s1.length() != s2.length())
            return false;
        boolean[][][] dp = new boolean[s1.length()][s2.length()][s2.length() + 1];
        for(int k = 1; k < s2.length() + 1; k++)
        {
            for(int i = 0; i + k<= s1.length(); i++)
            {
                for(int j = 0; j + k <= s2.length(); j++)
                {
                    if(k == 1)
                    {
                        dp[i][j][k] = s1.charAt(i) == s2.charAt(j);
                    }
                    else
                    {
                        for(int p = 1; p < k && !dp[i][j][k]; p++)
                        {
                            dp[i][j][k] = ((dp[i][j][p])&&(dp[i + p][j + p][k - p]))||((dp[i][j + k - p][p])&&(dp[i +p][j][k - p]));
                        }
                    }
                }
            }
        }
        return dp[0][0][s2.length()];
    }
}