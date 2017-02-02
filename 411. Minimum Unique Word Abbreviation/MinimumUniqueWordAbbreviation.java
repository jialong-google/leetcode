public class Solution {
    //candidate records all the bits which are different from target
    private int n, bn, cand, minLen, minab;
    private List<Integer> dict = new ArrayList<Integer>();
    private int abbrLen(int mask)
    {
        int count = n;
        for(int b = 3; b < bn; b <<= 1)
        {
            if((mask & b) == 0)
                count --;
        }
        return count;
    }
    private void dfs(int bit, int mask)
    {
        int len = abbrLen(mask);
        if(len >= minLen)
            return;
        boolean match = true;
        for(Integer d : dict)
        {
            if((mask & d) == 0)
            {
                match = false;
                break;
            }
        }
        if(match)
        {
            minLen = len;
            minab = mask;
        }
        else
        {
            for(int b = bit; b < bn; b <<= 1)
            {
                if((b & cand) != 0)
                    dfs(b << 1, mask + b);
            }
        }
    }
    
    public String minAbbreviation(String target, String[] dictionary) {
        n = target.length();
        bn = 1 << n;
        cand = 0;
        minLen = Integer.MAX_VALUE;
        StringBuilder res = new StringBuilder();
        
        for(String s: dictionary)
        {
            int word = 0;
            if(s.length() != n)
                continue;
            for(int i = 0; i < n; i++)
            {
                if(s.charAt(i) != target.charAt(i))
                {
                    word |= 1 << i;
                }
            }
            dict.add(word);
            cand |= word;
        }
        dfs(1, 0);
        for(int i = 0; i < n; )
        {
            if((minab & (1 << i)) != 0)// bit i is 1
            {
                res.append(target.charAt(i++));
            }
            else
            {
                int j = i;
                while(i < n && (minab & (1 << i)) == 0)
                    i++;
                res.append(i - j);
            }
        }
        return res.toString();
    }
}