class Solution {
public:
    bool isInterleave(string s1, string s2, string s3) {
        int len1=s1.length();
        int len2=s2.length();
        if(s3.length()!=len1+len2)
            return false;
        bool dp[len1+1][len2+1];
        for(int i=0;i<len1+1;i++)
            for(int j=0;j<len2+1;j++)
                dp[i][j]=false;
        dp[0][0]=true;
        for(int i=1,j=0;i<len1+1;i++){
            if(s3[j++]==s1[i-1]){
                dp[i][0]=true;
                //j++;
            }
            else{
                dp[i][0]=false;
                break;            
            }
        }
        for(int i=1,j=0;i<len2+1;i++){
            if(s3[j++]==s2[i-1]){
                dp[0][i]=true;
                //j++;
            }
            else{
                dp[0][i]=false;
                break;
            }
        }
        for(int i=1;i<len1+1;i++)
            for(int j=1;j<len2+1;j++){
                if( (s1[i-1]==s3[i+j-1] && dp[i-1][j] )||( s2[j-1]==s3[i+j-1] && dp[i][j-1] ) )
                    dp[i][j]=true;
            }
        return dp[len1][len2];
    }
};