class Solution {
public:
    int minCut(string s) {
        int len= s.length();
        int result[len+1];
        for(int i=0;i<len+1;i++){//the result[i] = cut needed for s[0~i-1]
            result[i]=i-1;
        }
        for(int i=0;i<len;i++){
            //the odd palindrome with i centered.
            for(int j=0;i-j>=0& i+j<len & s[i-j]==s[i+j];j++){
                result[i+j+1]=min(result[i+j+1],result[i-j]+1);
            }
            //the even palindrome with i+0.5 centered.
            for(int j=0; s[i-j+1]==s[i+j]& i+j<len&i-j+1>=0; j++)
            {
                result[i+j+1]=min(result[i+j+1],result[i-j+1]+1);
            }            
        }
        
        return result[len];
    }
};