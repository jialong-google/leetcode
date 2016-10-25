public class Solution {
    //102 900
    public int findNthDigit(int n) {
        long digitRow = 9;
        int width = 1;
        while(n > digitRow * width)
        {
            n -= digitRow * width;
            width ++;
            digitRow *= 10;
        }
        long num = digitRow /9 + (n - 1) / width;
        String res = num + "";
        return res.charAt((n - 1)% width) - '0';
    }
}