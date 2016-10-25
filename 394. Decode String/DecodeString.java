public class Solution {
    public class Cell{
        int times;
        String content;
        Cell(){
            content = new String();
        }
    }
    public String repeat(int times, String content)
    {
        if(times <= 1)
        {
            return content;
        }
        String half = repeat(times / 2, content);
        if(times %2 == 0)
        {
            return half+ half;
        }
        else
        {
            return half + half + content;
        }
    }
    public String decodeString(String s) {
        if(s == null)
            return new String();
        Deque<Cell> stack = new LinkedList<Cell>();
        Cell res = new Cell();
        stack.offerLast(res);
        int num = 0;
        for(int i = 0; i < s.length(); i++)
        {
            char cur = s.charAt(i);
            if(cur >= '0' && cur <='9')
            {
                num = num * 10 + (cur - '0');
            }
            else if(cur == '[')
            {
                Cell top = new Cell();
                top.times = num;
                num = 0;
                stack.offerLast(top);
            }
            else if(cur == ']')
            {
                Cell top = stack.pollLast();
                String top_string = repeat(top.times, top.content);
                stack.peekLast().content += top_string;
            }
            else// is a character.
            {
                Cell top = stack.peekLast();
                top.content += cur;
            }
        }
        return stack.pollLast().content;
    }
}