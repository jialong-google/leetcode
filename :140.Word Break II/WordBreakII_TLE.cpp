class Solution {
private:
    unordered_map<int, vector<string> > path;
public:
    vector<string> wordBreak(string s, unordered_set<string>& wordDict) {
        for(int i=s.size()-1;i>=0;i--){
            if(wordDict.count(s.substr(i)))
                path[i].push_back(s.substr(i));
            for(int j=i+1;j<s.size();j++)
                if(!path[j].empty() && wordDict.count(s.substr(i,j-i)))
                {
                    for(int q=path[j].size()-1;q>=0;q--){
                        path[j][q]=s.substr(i,j-i)+" "+path[j][q];
                        path[i].push_back(path[j][q]);
                    }
                }
        }
        return path[0];
    }
};