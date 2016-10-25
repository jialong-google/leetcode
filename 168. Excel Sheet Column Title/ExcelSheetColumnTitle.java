public class Solution {
    public String convertToTitle(int n) {
        if(n <= 0)
            return "";
        StringBuilder writer = new StringBuilder();
        while(n > 0)
        {
            int r = n % 26;
            n = n /26;
            if(r == 0)
            {
                n --;
                writer.append("Z");
            }
            else
            {
                writer.append((char)(r - 1 + 'A'));
            }
        }
        return writer.reverse().toString();
    }
}