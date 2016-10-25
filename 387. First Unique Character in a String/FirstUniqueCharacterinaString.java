public class Solution {
    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0)
            return -1;
        Map<Character, Integer> map = new HashMap<Character, Integer>(26);
        for(int i = 0; i < s.length(); i++)
        {
            char current = s.charAt(i);
            Integer time = map.get(current);
            if(time == null)
            {
                map.put(current, 1);
            }
            else
            {
                map.put(current, time + 1);
            }
        }
        for(int i = 0; i < s.length(); i ++)
        {
            char current = s.charAt(i);
            if(map.get(current) == 1)
            {
                return i;
            }
        }
        return -1;
        
    }
}