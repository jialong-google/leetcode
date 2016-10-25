public class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s == null || s.length() == 0)
            return true;
        if(t == null || t.length() == 0)
            return false;
        char[] s_long = s.toCharArray();
        char[] t_long = t.toCharArray();
        int i = 0;
        int j = 0;
        while(j < t_long.length)
        {
            if(s_long[i] == t_long[j])
            {
                i++;
                if(i == s_long.length)
                    return true;
            }
            j++;
        }
        return false;
    }
}