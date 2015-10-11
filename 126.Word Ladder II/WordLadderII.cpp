using namespace std;
class Solution {
public:

    void DFS(string start, string end, unordered_map<string,vector<string>> &one2before,vector<vector<string>> &path,vector<string> onepath){
        onepath.insert(onepath.begin(),end);
        if(start==end)
            path.push_back(onepath);
        else
            for(int i=0;i<one2before[end].size();i++)
                DFS(start,one2before[end][i],one2before,path,onepath);
            
    }
    
    vector<vector<string>> findLadders(string beginWord, string endWord, unordered_set<string> &wordList) {
        unordered_map< string, int> distance;
        unordered_map< string, vector<string> > one2before;
        queue< string > q;
        q.push(beginWord);
        distance[beginWord]=1;
        while(!q.empty()){
            string word=q.front();
            q.pop();
            if(word==endWord)  break;
            else{
                //form a new word, and test if it is in the wordList
                //if yes
                for(int i=0;i<word.size();i++)
                    for(int j=0;j<26;j++){
                        string nw=word;
                        nw[i]='a'+j;
                        if(wordList.count(nw)>0)
                            if(distance.count(nw)==0){
                                distance[nw]=distance[word]+1;
                                vector< string > before;
                                before.push_back(word);
                                one2before[nw]=before;
                                q.push(nw);
                            }
                            else if(distance[nw]==distance[word]+1)
                                one2before[nw].push_back(word);// no putting in queue.
                    }
            }
        }
        vector< vector< string > > path;
        vector< string > nothing;
        DFS(beginWord,endWord,one2before,path,nothing);
        return path;
    }
};