public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        if((abbr == null || abbr.length() == 0) && (word == null || abbr.length() == 0))
            return true;
        int j = 0;
        int num = 0;
        for(int i = 0; i < abbr.length(); i++)
        {
            if(num == 0 && abbr.charAt(i) == '0')//corner case 1: a number begins with 0.
                return false;
            if(abbr.charAt(i) <='9' && abbr.charAt(i) >= '0')
            {
                num = num * 10 + abbr.charAt(i) - '0';
            }
            else
            {
                j += num;
                num = 0;
                if(j >= word.length() || abbr.charAt(i) != word.charAt(j))
                {
                    return false;
                }
                else
                {
                    j++;
                }
            }
        }
        if(j + num == word.length())// corner case2, the word length does not match.
            return true;
        return false;
    }
}