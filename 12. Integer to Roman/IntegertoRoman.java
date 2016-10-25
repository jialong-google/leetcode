public class Solution {
    public String intToRoman(int num) {
        if(num <= 0 || num >= 4000)
            return new String();
        // I : 1;
        // V : 5;
        // X : 10;
        // L : 50;
        // C : 100;
        // D : 500;
        // M : 1000;
        char[] roman = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(num != 0)
        {
            int current = num % 10;
            if(current <= 3)
            {
                for(int i = 0; i < current; i++)
                {
                    sb.append(roman[index]);
                }
            }
            else if(current <= 5)
            {
                sb.append(roman[index + 1]);
                for(int i = 0; 5 - i > current; i++)
                {
                    sb.append(roman[index]);
                }
            }
            else if(current <= 8)
            {
                for(int i = 0; i + 5 < current; i++)
                {
                    sb.append(roman[index]);
                }
                sb.append(roman[index + 1]);
            }
            else if(current <=9)
            {
                sb.append(roman[index + 2]);
                for(int i = 0; 10 - i > current; i++)
                {
                    sb.append(roman[index]);
                }
            }
            index = index + 2;
            num = num / 10;
        }
        sb.reverse();
        return sb.toString();
    }
}