public class Solution {
    public String reverseString(String s) {
        if(s == null || s.length() == 0)
            return s;
        char[] input = s.toCharArray();
        int begin = 0;
        int end = s.length() -1;
        while(begin < end)
        {
            char tmp = input[begin];
            input[begin] = input[end];
            input[end] = tmp;
            begin ++; end -- ;
        }
        return new String(input);
    }
}