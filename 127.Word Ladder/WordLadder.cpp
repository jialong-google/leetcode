class Solution {
public:
    
    bool neighbor(string a,string b){
        int count=0;
        for(int i=0;i<a.size();i++){
            if(a[i]!=b[i])
                count++;
        }
        if(count==1)
            return true;
        else
            return false;
    }
    vector<string> find_neighbors(string begin,unordered_set<string>& wordList){
        //return the vector of strings that has only 1 charactor not in common.
        unordered_set<string>:: iterator i;
        vector<string> l;
        for(i=wordList.begin();i!=wordList.end();i++){
            //judge if *i is a neighbor.
            //if yes, add it in the list;
            if(neighbor(begin,*i))
                l.push_back(*i);
        }
        return l;
        
    }
    
    //not mine.
    vector<string> findNeighbors(string s, unordered_set<string> &dict) {
        vector<string> ret;
        for(int i=0; i<s.size(); i++) {
            char c = s[i];
            for(int j=0; j<26; j++) {
                if(c=='a'+j) continue;
                s[i] = 'a'+j;
                if(dict.count(s)) {
                    ret.push_back(s);    
                    dict.erase(s);    
                }
            }
            s[i] = c;
        }
        return ret;
    }
    
    int ladderLength(string beginWord, string endWord, unordered_set<string>& wordList) {
        queue<pair<string,int>> q;
        wordList.insert(endWord);
        int depth=1;
        q.push(make_pair(beginWord,depth));
        while(!q.empty()){
            string s=q.front().first;
            int d=q.front().second;
            //if s is the thing we need. return its depth.
            if(s==endWord) return d;
            //add all neighbors into the queue;
            q.pop();
            //wordList.erase(s);
            vector<string> l=findNeighbors(s,wordList);
            for(int i=0;i<l.size();i++)
                q.push(make_pair(l[i],d+1));
        }
        
    }
    
    
};