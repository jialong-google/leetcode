class Solution {
    string sand[5] = {"Thousand ", "Million ", "Billion ", "Trillion ","Quadrillion "};
    string ten[19]={"One ","Two ","Three ","Four ","Five ","Six ","Seven ","Eight ","Nine ","Ten ","Eleven ","Twelve ","Thirteen ","Fourteen ","Fifteen ","Sixteen ","Seventeen ","Eighteen ","Nineteen "};
    string ty[8]={"Twenty ","Thirty ","Forty ","Fifty ","Sixty ","Seventy ","Eighty ","Ninety "};
public:
    string withinthousand(int num){
        string s;
        if(num==0)
            return s;
        if(num/100!=0)
        {
            s=ten[num/100-1];
            s+="Hundred ";
        }
        num=num%100;
        if(num<=19)
        {
            if(num!=0)
                s+=ten[num-1];
            return s;
        }
        else
        {
            s+=ty[num/10-2];
            if(num%10!=0)
                s+=ten[num%10-1];
            return s;
        }
            
    }
    string numberToWords(int num) {
        string res;
        int wt=num%1000;
        int hi=num/1000;
        if(wt==0 &&hi==0)
            return "Zero";
        res+=withinthousand(wt);
        int i=0;
        while(hi!=0)
        {
            wt=hi%1000;
            string r=withinthousand(wt);
            if(!r.empty())
                res=withinthousand(wt)+sand[i++]+res;
            else
                i++;
            hi=hi/1000;
            if(i>=5)
                return "";
        }
        return res.substr(0,res.length()-1);
    }
};