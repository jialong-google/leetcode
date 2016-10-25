public class Solution {
    public int longestPalindrome(String s) {
        int[] lower = new int[26];
        int[] upper = new int[26];
        for(int i = 0; i < s.length(); i++)
        {
            char current = s.charAt(i);
            if(current >= 'a' && current <= 'z')
            {
                lower[current - 'a'] ++;
            }
            if(current >= 'A' && current <= 'Z')
            {
                upper[current - 'A'] ++;
            }
        }
        int res = 0;
        boolean addone = false;
        for(int i = 0; i < 26; i++)
        {
            if(lower[i] % 2 != 0)
            {
                res += lower[i] - 1;
                addone = true;
            }
            else
            {
                res += lower[i];
            }
            if(upper[i] % 2 != 0)
            {
                res += upper[i] - 1;
                addone = true;
            }
            else
            {
                res += upper[i];
            }
        }
        if(addone == true)
        {
            return res + 1;
        }
        return res;
    }
}