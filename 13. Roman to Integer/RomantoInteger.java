public class Solution {
    // I V X L C D M
    public int dict(char s){
        switch(s)
        {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
    public int romanToInt(String s) {
        if(s == null || s.length() == 0)
        {
            return 0;
        }
        int prev = dict(s.charAt(0));
        int res = 0;
        for(int i = 1; i < s.length(); i++)
        {
            int current = dict(s.charAt(i));
            if(current > prev)
            {
                res += -prev;
            }
            else
            {
                res += prev;
            }
            prev = current;
        }
        
        return res + dict(s.charAt(s.length() - 1));
    }
}