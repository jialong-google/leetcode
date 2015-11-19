class Solution {
public:
    bool wordBreak(string s, unordered_set<string>& wordDict) {
        unordered_set<int> location;
        bool dp[s.size()];
        for(int i=s.size()-1;i>=0;i--)
            dp[i]=false;
            
        for(int i=s.size()-1;i>=0;i--){
            if(wordDict.count(s.substr(i))>0)
                dp[i]=true;
            for(int j=i+1;j<s.size();j++){
                if(dp[j] && wordDict.count(s.substr(i,j-i)))
                    dp[i]=true;
            }
        }
        return dp[0];
    }
};