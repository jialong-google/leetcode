public class Solution {
    public boolean validUtf8(int[] data) {
        if(data == null || data.length == 0)
            return true;
        int oneMask = 0x80;// 1000 0000
        int twoMask = 0xE0;// 1110 0000
        int goOn = 0xC0;// 1100 0000
        int threeMask = 0xF0;// 1111 0000
        int fourMask = 0xF8;// 1111 1000
        for(int i = 0; i < data.length; i++)
        {
            int loop = 0;
            if((data[i] & oneMask) == 0)// 1000 0000
            {
                continue;
            }
            else if((data[i] & twoMask) == 0xC0)// 1100 0000
            {
                loop = 2;
            }
            else if((data[i] & threeMask) == 0xE0)// 1110 0000
            {
                loop = 3;
            }
            else if((data[i] & fourMask) == 0xF0)// 1111 0000
            {
                loop = 4;
            }
            else
            {
                return false;
            }
            for(int j = 1; j < loop; j++)
            {
                if(i + 1 >= data.length || (data[++i] & goOn) != 0x80)// 1000 0000
                {
                    return false;
                }
            }
        }
        return true;
    }
}