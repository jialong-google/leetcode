public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if((s == null && t == null) || (s.length() == 0 && t.length() == 0))
            return true;
        if(s.length() != t.length())
            return false;
        
        Map<Character, Character> stot = new HashMap<Character, Character>();
        Map<Character, Character> ttos = new HashMap<Character, Character>();
        for(int i = 0; i < s.length(); i++)
        {
            Character st = stot.get(s.charAt(i));
            if(st == null)
            {
                stot.put(s.charAt(i), t.charAt(i));
            }
            else if(st != t.charAt(i))
            {
                return false;
            }
            Character ts = ttos.get(t.charAt(i));
            if(ts == null)
            {
                ttos.put(t.charAt(i), s.charAt(i));
            }
            else if(ts != s.charAt(i))
            {
                return false;
            }
        }
        return true;
    }
}