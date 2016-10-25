public class Solution {
    public String addStrings(String num1, String num2) {
        if(num1 == null || num1.length() == 0 )
            return num2;
        if(num2 == null || num2.length() == 0 )
            return num1;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder writer = new StringBuilder();
        int carry = 0;
        while(i >= 0 && j >= 0)
        {
            int cur1 = num1.charAt(i) - '0';
            int cur2 = num2.charAt(j) - '0';
            writer.append((char)((cur1 + cur2 +carry)%10 + '0'));
            carry = (cur1 + cur2 + carry)/10;
            i--;
            j--;
        }
        while(i >= 0)
        {
            int cur1 = num1.charAt(i) - '0';
            writer.append((char)((cur1 + carry) % 10 + '0'));
            carry = (cur1 + carry) / 10;
            i--;
        }
        
        while(j >= 0)
        {
            int cur2 = num2.charAt(j) - '0';
            writer.append((char)((cur2 + carry) % 10 + '0'));
            carry = (cur2 + carry) / 10;
            j--;
        }
        if(carry != 0)
        {
            writer.append('1');
        }
        return writer.reverse().toString();
    }
}