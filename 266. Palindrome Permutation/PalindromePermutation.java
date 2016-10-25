public class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Boolean> hash = new HashMap<Character, Boolean>();
        int number = 0;
        for(int i = 0; i < s.length(); i++)
        {
            char cur = s.charAt(i);
            Boolean res = hash.get(cur);
            if(res == null)
            {
                hash.put(cur, true);
                number ++;
                continue;
            }
            if(res.booleanValue() == false)
            {
                hash.put(cur, true);
                number ++;
            }
            else
            {
                hash.put(cur, false);
                number--;
            }
            
        }
        if(number > 1)
        {
            return false;
        }
        return true;
    }
}