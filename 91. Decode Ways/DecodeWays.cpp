class Solution {
public:
    int numDecodings(string s) {
        if(s.empty())
            return 0;
        int len=s.length();//len>=1
        
        int dp[len+1];//dp.length >=2
        if(s[0]=='0')
            return 0;
        for(int i=0;i<len+1;i++)
            dp[i]=0;
        dp[0]=1;
        dp[1]=1;
        
        for(int i=1;i<len;i++)//填dp[i+1]
        {
            int r=10*(s[i-1]-'0')+s[i]-'0';
            if(s[i-1]=='0' && s[i]=='0')
                return 0;
            else if(s[i-1]!='0' && s[i]=='0')
            {
                if(r>9 && r<=26)
                    dp[i+1]=dp[i-1];
                else
                    return 0;
            }
            else if(s[i-1]=='0' && s[i]!='0')
            {
                dp[i+1]=dp[i-1];
            }
            else{//i-1 !='0' i != '0'
                if(r>9 && r<=26)
                    dp[i+1]=dp[i]+dp[i-1];
                else
                    dp[i+1]=dp[i];
            }
        }
        return dp[len];
    }
};