public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";
        int len = strs[0].length();
        String cur = strs[0];
        for(int i = 1; i < strs.length; i++)
        {
            for(int j = 0; j < strs[i].length(); j++)
            {
                if(len > j && cur.charAt(j) != strs[i].charAt(j))
                {
                    len = j;
                    break;
                }
            }
            len = Math.min(strs[i].length(), len);
        }
        return cur.substring(0, len);
    }
}