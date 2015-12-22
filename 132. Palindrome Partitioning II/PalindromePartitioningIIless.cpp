class Solution {
public:
    int minCut(string s) {
        int len= s.length();
        if(len<=1)
            return 0;
        int result[len+1];
        bool pal[len][len];
        for(int i=0;i<len;i++)
            for(int j=0;j<len;j++)
                pal[i][j]=false;
        
        for(int i=len-1;i>=0;i--)
            for(int j=i;j<len;j++){
                if(( i+1>j-1 || pal[i+1][j-1] ) && s[i]==s[j]){
                    pal[i][j]=true;
                }
            }
        
        for(int i=0;i<len+1;i++){//the result[i] = cut needed for s[0~i-1]
            result[i]=i-1;
        }
        for(int i=0;i<len;i++){
            for(int j=i;j>=0;j--){
                if(pal[j][i])
                {
                    result[i+1]=min(result[i+1],result[j]+1);
                }
            }
        }
        
        return result[len];
    }
};