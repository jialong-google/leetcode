public class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int len = 0;
        int initial = s.length() -1; 
        while(initial >= 0 && s.charAt(initial) == ' ')
        {
            initial -- ;
        }
        if(initial < 0)
            return 0;
        for(int i = initial;i >= 0; i--)
        {
            
            if(s.charAt(i) == ' ')
            {
                return initial - i;
            }
        }
        return initial + 1;

    }
}