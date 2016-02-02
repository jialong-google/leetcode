class Solution {
public:
    bool isDigit(char c)
    {
        if(c>='0'&&c<='9')
            return true;
        else
            return false;
    }
    int myAtoi(string str) {
        long long int res=0;
        int len=str.length();
        if(str.empty())
            return 0;
        bool isnegative=false;
        int i=0;
        while(str[i]==' ')
            i++;
        if(str[i]=='+'){
            isnegative=false;
            i++;
        }
        else if(str[i]=='-')
        {    
            isnegative=true;
            i++;
        }
        while(i<len)
        {
            if(!isDigit(str[i]) || ((long long int)((int)res))!=res)
                break;
            res=res*10+str[i]-'0';
            i++;
        }
        res=(isnegative==true? -res:res);
        if(((long long int)((int)res))==res)
            return (int)res;
        else if(isnegative)
            return INT_MIN;
        else
            return INT_MAX;
    }
};