class Solution {
public:
    vector<string> wordBreak(string s, unordered_set<string>& wordDict) {
        vector<vector<int>> tbl=genTable(s,wordDict);
        vector<string> result;
        string tmp;
        genSolution(s,result,tmp,tbl,0);
        return result;
    }
    void genSolution(string s, vector<string> &r, string &tmp, vector<vector<int>> &tb ,int count){
        if(count==tb.size())
        {
            r.push_back(tmp.substr(0,tmp.length()-1));
            return;
        }
        if(!tb[count].empty())
        {
            for(int j=tb[count].size()-1;j>=0;j--){
                string t;//here is very tricky.
                t=tmp+s.substr(count, tb[count][j]-count)+" ";
                //if here we assign tmp=tmp+string, when we come back, tmp has been changed.
                genSolution(s,r,t,tb,tb[count][j]);
            }
        }
    }
    vector<vector<int>> genTable(string s, unordered_set<string>& wordDict){
        int len=s.length();
        vector<vector<int>> tb(len);
        for(int i=len-1;i>=0;i--)
        {
            if(wordDict.count(s.substr(i,len-i))){
                tb[i].push_back(len);
            }
        }
        for(int i=len-1;i>=0;i--){
            if(!tb[i].empty())
            {
                for(int j=i-1;j>=0;j--){
                    if(wordDict.count(s.substr(j,i-j))){
                        tb[j].push_back(i);//j->i | i+1
                    }
                }
            }
        }
        return tb;
    }
};