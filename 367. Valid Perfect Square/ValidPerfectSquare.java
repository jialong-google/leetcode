public class Solution {
    public boolean isPerfectSquare(int num) {
        if(num < 0)
            return false;
        long begin = 0;
        long end = num / 2;
        if(num == 1)
            return true;
        long x = num;
        while(begin <= end)
        {
            long medium = begin + (end - begin) /2 ;
            if(medium * medium < x)
            {
                begin = medium + 1;
            }
            else if(medium * medium > x)
            {
                end = medium -1;
            }
            else
                return true;
        }
        if(begin * begin != x && end * end != x)
        {
            return false;
        }
        return true;
    }
}