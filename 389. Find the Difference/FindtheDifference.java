public class Solution {
    public char findTheDifference(String s, String t) {
        char temp = (char)0;
        for(int i = 0; i < s.length(); i++ )
        {
            temp ^= s.charAt(i);
        }
        for(int j = 0; j < t.length(); j++)
        {
            temp ^= t.charAt(j);
        }
        return temp;
    }
}