public class Solution {
    public String reverseVowels(String s) {
        if(s == null || s.length() == 0)
            return s;
        char[] input = s.toCharArray();
        Set<Character> hash = new HashSet<Character>();
        hash.add('A');hash.add('E');hash.add('I');hash.add('O');hash.add('U');
        hash.add('a');hash.add('e');hash.add('i');hash.add('o');hash.add('u');
        int begin = 0;
        int end = input.length - 1;
        while(begin < end)
        {
            while(begin <end && hash.contains(input[begin]) == false)
            {
                begin ++;
            }
            while(begin < end && hash.contains(input[end]) == false)
            {
                end --;
            }
            char temp = input[begin];
            input[begin] = input[end];
            input[end] = temp;
            //if(begin < input.length - 1)
                begin ++;
            //if(end >= 1)
                end--;
        }
        return new String(input);
    }
}