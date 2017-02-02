public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s == null || s.length() == 0 || p == null || p.length() == 0)
            return new ArrayList<Integer>();
        List<Integer> res = new ArrayList<Integer>();
        int number_in_total = p.length();
        int[] hash = new int[256];
        for(int i = 0; i < p.length(); i++)
        {
            hash[p.charAt(i)] ++;
        }
        int begin = -1;
        int end = -1;
        while(end < s.length() - 1)
        {
            end ++;
            
            if(hash[s.charAt(end)] -- >= 1)
            {
                number_in_total--;
            }
            
            if(number_in_total == 0)
            {
                res.add(begin + 1);
            }
            
            if(end - begin == p.length())
            {
                begin ++;
                if(hash[s.charAt(begin)]++ >= 0)
                {
                    number_in_total ++;
                }
            }
        }
        return res;
    }
}