public class Solution {
    public int integerBreak(int n) {
        if(n == 2 || n == 3)
            return n - 1;
        return helper(n);
    }
    public int helper(int n )
    {
        //if(n == 2 || n == 3)
        //    return n;
        if(n > 4)
            return helper(n - 3) * 3;
        return n;
    }
}