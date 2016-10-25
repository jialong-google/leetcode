public class Solution {
    public int reverse(int x) {
        long num = 0;
        boolean neg = (x < 0);
        long xx = neg? -x: x;
        while(xx != 0)
        {
            num = num * 10 + xx % 10;
            xx /= 10;
        }
        if(neg)
        {
            num = -num;
        }
        if(((long) ((int) num)) == num)
        {
            return (int) num;
        }
        else
        {
            return 0;
        }
    }
}