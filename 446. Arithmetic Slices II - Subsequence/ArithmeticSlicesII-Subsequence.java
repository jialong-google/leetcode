public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length == 0)
            return 0;
        int res = 0;
        Map<Integer, Integer>[] dp = new Map[A.length];
        for(int i = 0; i < A.length; i++)
        {
            dp[i] = new HashMap<Integer, Integer>();
            int current = A[i];
            for(int j = 0; j < i; j++)
            {
                if((long)current - A[j] > Integer.MAX_VALUE || (long) current - A[j] < Integer.MIN_VALUE)
                    continue;
                int diff = current - A[j];
                Integer temp = dp[j].get(diff);
                
                if(temp == null)
                {
                    dp[i].put(diff, dp[i].getOrDefault(diff, 0) + 1);// should consider the case that diff already contained.
                }
                else
                {
                    
                    dp[i].put(diff, dp[i].getOrDefault(diff, 0) + temp + 1);// the same above.
                    res += temp;
                }
            }
        }
        return res;
    }
}