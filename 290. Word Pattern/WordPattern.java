public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if(pattern.length() != strs.length)
            return false;
        Map<Character, String> hash = new HashMap<Character, String>();
        for(int i = 0; i < pattern.length(); i++)
        {
            char cur = pattern.charAt(i);
            String contain = hash.get(cur);
            if(contain == null)
            {
                if(hash.containsValue(strs[i]))
                {
                    return false;
                }
                hash.put(cur, strs[i]);
            }
            else
            {
                if(!strs[i].equals(contain))
                {
                    return false;
                }
            }
        }
        return true;
    }
}