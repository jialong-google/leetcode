public class Solution {
    private void reverse(char[] input, int i, int j)
    {
        while(i < j)
        {
            char temp = input[i];
            input[i] = input[j];
            input[j] = temp;
            i++;
            j--;
        }
    }
    private String shorten(char[] input)
    {
        int slow = 0;
        int fast = 0;
        boolean appear = false;
        while(fast < input.length)
        {
            if(appear == true && input[fast] == ' ')
            {
                fast++;
            }
            else //if(appear == false)
            {
                input[slow] = input[fast];
                appear = (input[fast] == ' ');
                fast++;
                slow++;
            }
        }
        return new String(input, 0, slow);
    }
    public String reverseWords(String s) {
        s = s.trim();
        char[] sarray = s.toCharArray();
        int begin = 0;
        int last = s.length() - 1;
        while(begin < last)
        {
            char temp = sarray[begin];
            sarray[begin] = sarray[last];
            sarray[last] = temp;
            last --;
            begin ++;
        }
        int prev = 0;
        for(int i = 0; i < sarray.length; i++)
        {
            if(sarray[i] == ' ')
            {
                reverse(sarray, prev, i - 1);
                prev = i + 1;
            }
        }
        reverse(sarray, prev, sarray.length - 1);
        return shorten(sarray);
    }
}