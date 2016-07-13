public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null)
            return -1;
        if(needle.length() == 0)
            return 0;
        int[] next = next(needle);
        int i = 0;
        int j = 0;
        while(i <= haystack.length() - needle.length())
        {
            //System.out.println("i: "+i+" j: "+j);
            while(j< needle.length() && haystack.charAt(i + j) == needle.charAt(j))
            {
                j++;
            }
            if(j == needle.length())
                return i;
            else if(j == 0)
            {
                i++;
            }
            else
            {
                i += j - next[j - 1];
                j = next[j - 1];
            }
        }
        return -1;
    }
    public int[] next(String pattern)
    {
        int[] next = new int [pattern.length()];
        next[0] = 0;
        for(int i = 1; i < next.length; i++)
        {
            int index = next[i - 1];
            while(index > 0 && pattern.charAt(index) != pattern.charAt(i))
                index = next[index - 1];
            if(pattern.charAt(index) == pattern.charAt(i))
                next[i] = next[index] + 1;
            else
                next[i] = 0;
        }
        return next;
    }
}