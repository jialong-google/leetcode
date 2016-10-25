public class Solution {
    public String toHex(int num) {
        StringBuilder writer = new StringBuilder();
        if(num == 0)
            return new String("0");
        while(num != 0)
        {
            int cur = (num & 0x0f);
            if(cur < 10)
            {
                writer.append((char)(cur + '0'));
            }
            else
            {
                writer.append((char)((cur - 10) + 'a') );
            }
            num >>>= 4;
        }
        writer.reverse();
        return writer.toString();
    }
}