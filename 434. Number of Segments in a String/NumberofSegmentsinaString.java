public class Solution {
    public int countSegments(String s) {
        if(s == null || s.length() == 0)
            return 0;
        s = s.trim();
        if(s.isEmpty())
            return 0;
        System.out.println(s);
        int res = 0;
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == ' ')
            {
                res ++;
                while(i < s.length() && s.charAt(i) == ' ')
                {
                    i ++;
                }
            }
        }
        return res + 1;
    }
}