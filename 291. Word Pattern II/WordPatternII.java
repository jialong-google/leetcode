public class Solution {
    Map<Character, String> map = new HashMap<Character, String>();
    Set<String> set = new HashSet<String>();
    public boolean wordPatternMatch(String pattern, String str) {
        if(pattern.isEmpty())
            return str.isEmpty();
        char cur = pattern.charAt(0);
        String curMap = map.get(cur);
        if(curMap != null)
        {
            if(str.length() < curMap.length() || !str.substring(0, curMap.length()).equals(curMap))
                return false;
            if(wordPatternMatch(pattern.substring(1), str.substring(curMap.length())))
                return true;
        }
        else
        {
            for(int i = 0; i < str.length(); i++)
            {
                String temp = str.substring(0, i+ 1);
                if(!set.add(temp))
                    continue;
                map.put(cur, temp);
                if(wordPatternMatch(pattern.substring(1), str.substring(i + 1)))
                    return true;
                map.remove(cur);
                set.remove(temp);
            }
            //return false;
        }
        return false;
    }
}