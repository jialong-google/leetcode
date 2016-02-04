class Solution {
public:
    int divide(int dividend, int divisor) {
        if(divisor==0)
            return INT_MAX;
        if(divisor==1)
            return dividend;
        if(divisor==-1)
            return -dividend;
        int count=0;
        int sign=1;
        if((dividend>0 && divisor<0 )&&(dividend<0 && divisor>0 ))
            sign=-1;
        int abs_dividend=abs(dividend);
        int abs_divisor=abs(divisor);
        
        while(abs_dividend-abs_divisor>=0){
            abs_dividend-=abs_divisor;
            count++;
            if(count==INT_MAX)
                break;
        }
            return count*sign;
    }
};