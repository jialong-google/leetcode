class Solution {
public:
    int divide(int dividend, int divisor) {
        bool isnegative=false;
        if((dividend<0 && divisor>0)||(dividend>0 && divisor<0))
            isnegative=true;
        if(divisor==0)
            return INT_MAX;
        long long int a=dividend;
        long long int b=divisor;
        a=abs(a);
        b=abs(b);
        long long int res=0;
        long long int c=1;
        while(a>b)
        {
            b=b<<1;
            c=c<<1;
        }
        
        while(c!=0)
        {
            while(a>=b)//!!!!!!!!!!!!!!
            {
                a=a-b;
                res=res+c;
            }
            b=b>>1;
            c=c>>1;
        }
        res= isnegative? -res:res;
        if((long long int)((int)(res))==res)
            return res;
        else
            return INT_MAX;
        
    }
};