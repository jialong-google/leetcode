public class Solution {
    public double myPow(double x, int n) {
        if(n >= 0)
            return helper(x, n);
        if(n != Integer.MIN_VALUE)
            return 1.0 / helper( x, -n);
        else
            return (1.0 / x)*1.0 / (helper(x, Integer.MAX_VALUE)) ;
        //return helper(x, n);
    }
    public double helper(double x, int n){
        if(n == 0)
            return 1;
        if(n == 1)
            return x;
        double half = myPow(x, n/2);
        if(n % 2 == 0)
            return half * half;
        else
            return half * half * x;
    }
      
}