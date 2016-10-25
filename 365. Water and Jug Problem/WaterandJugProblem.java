public class Solution {
    public int getGCD(int x, int y)
    {
        if(y == 0)
            return x;
        return getGCD(y, x % y);
    }
    public boolean canMeasureWater(int x, int y, int z) {
        if(z > x + y || z < 0)  
            return false;
        if(z == 0)
            return true;
        if(x == 0 && y == 0)
            return false;
        if(x == 0)
            return z % y == 0;
        if(y == 0)
            return z % x == 0;
        if(x > y)
        {
            int temp = x;
            x = y;
            y = temp;
        }
        int res = getGCD(x, y);
        //System.out.println(res);
        if(res == 1)
            return true;
        return z % x == 0;
    }
}