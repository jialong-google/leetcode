public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0)
        {
            return 0;
        }
        int i = 0; // mark the beginning of the substring.
        int diff = -1;// mark the last letter which is not the same as k.
        int count = 0;
        for(int k = 1; k < s.length(); k++)
        {
            if(s.charAt(k) == s.charAt(k - 1))
                continue;
            if(j != -1 && s.charAt(k) != s.charAt(diff))
            {
                count = Math.max(count, k - i);
                i = diff + 1;
            }
            diff = k - 1;
        }
        return count > (s.length() - i) ? count: s.length() - i;
    }
}