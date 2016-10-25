public class Solution {
        
    public String addBinary(String a, String b) {
        if(a == null || a.length() == 0)
            return b;
        if(b == null || b.length() == 0)
            return a;
        int carry = 0;
        StringBuilder writer = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        while(i >= 0 && j >= 0)
        {
            int cur1 = a.charAt(i) - '0';
            int cur2 = b.charAt(j) - '0';
            
            writer.append((char)((cur1 + cur2 +carry ) % 2 + '0'));
            carry = (cur1 + cur2 +  carry) / 2;
            i --;
            j--;
        }
        while(i >= 0)
        {
            int cur1 = a.charAt(i) - '0';
            writer.append((char)((cur1 + carry) % 2 + '0'));
            carry = (cur1 + carry) / 2;
            i--;
        }
        while(j >= 0)
        {
            int cur2 = b.charAt(j) - '0';
            writer.append((char)((cur2 + carry) % 2 + '0'));
            carry = (cur2 + carry) / 2;
            j--;
        }
        if(carry != 0)
        {
            writer.append('1');
        }
        return writer.reverse().toString();
    }
}