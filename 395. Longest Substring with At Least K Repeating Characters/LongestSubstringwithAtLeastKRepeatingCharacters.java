public class Solution {
    public int longestSubstring(String s, int k) {
        if(s == null || s.length() == 0)
            return 0;
        int res = 0;
        int last = 0;
        int n = s.length();
        for(int i = 0; i + k < n; i = last + 1)
        {
            int[] hash = new int[26];
            int mask = 0;
            last = i;// this one is important.
            for(int j = i; j < n; j++)
            {
                int cur = s.charAt(j) - 'a';
                hash[cur]++;
                if(hash[cur] < k)
                {
                    mask |= (1<< cur);
                }
                else
                {
                    mask &= ~(1<<cur);
                }
                if(mask == 0)
                {
                    res = Math.max(j - i + 1,res);
                    last = j;
                }
            }
        }
        return res;
    }
}