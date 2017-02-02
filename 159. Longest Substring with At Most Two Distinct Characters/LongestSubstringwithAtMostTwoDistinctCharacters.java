public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int k = 2;
        if(s == null || s.length() == 0)
        {
            return 0;
        }
        Map<Character, Integer> hash = new HashMap<>();
        int i = 0; 
        int j = -1;
        int count = 0;
        int size = 0;
        while(j < s.length() - 1)
        {
            j++;
            Integer temp = hash.get(s.charAt(j));
            if(temp == null)
            {
                hash.put(s.charAt(j), 1);
                size ++;
            }
            else
            {
                hash.put(s.charAt(j), temp + 1);
            }
            if(size <= k)
            {
                count = Math.max(j - i + 1, count);
            }
            while(size > k)
            {
                Integer temp2 = hash.get(s.charAt(i));
                if(temp2 == 1)
                {
                    hash.remove(s.charAt(i));
                    size --;
                }
                else
                {
                    hash.put(s.charAt(i), temp2 - 1);
                }
                i++;
            }
        }
        return count;
    }
}