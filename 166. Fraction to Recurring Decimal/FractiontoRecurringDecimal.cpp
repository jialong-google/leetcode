class Solution {
public:
    string fractionToDecimal(int numerator, int denominator) {
        bool isnegative=false;
        if((numerator>0 && denominator<0)||(numerator<0 && denominator>0))
            isnegative=true;
        
        long long int n=numerator;
        long long int d=denominator;//!!!!!!!!!
        n=abs(n);
        d=abs(d);//!!!!!!!!!!
        string r;
        string re;
        unordered_map<int, int> left;
        
        if(isnegative)
            r="-";
        long long int leftover=n%d;
        if(leftover==0)
        {
            return r+to_string(n/d);
        }
        else
        {
            r=r+to_string(n/d)+".";
        }
        int i=1;
        while(leftover){
            leftover*=10;
            if(left.find(leftover)==left.end())
            {
                left[leftover]=i;
                r+=to_string(leftover/d);
            }
            else{
                re=r.substr(0,r.length()-i+left[leftover])+"("+r.substr(r.length()-i+left[leftover])+")";
                return re;
            }
            
            leftover=leftover%d;
            i++;
        }
        return r;
        
    }
};