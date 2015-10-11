struct TrieNode {
    bool end;
    char content;
    vector<TrieNode *> to;
};

class Trie {
public:
    Trie() {
        root = new TrieNode();
    }

    void insert(string word) {
        TrieNode * p=root;
        int len=word.length();
        for(int i=0;i<len;i++){
            int yes=-1;
            int lenofto=p->to.size();
            for(int j=0;j<lenofto;j++){
                if(p->to[j]->content == word[i])
                {
                    yes=j;
                    break;
                }
            }
            if(yes!=-1){
                p=p->to[yes];
                if(i==len-1)
                    p->end=true;
            }
            else if(i!=len-1){//不是最后一个节点
                TrieNode *node= new TrieNode();
                node->content=word[i];
                node->end=false;
                p->to.push_back(node);
                p=node;
            }
            else //最后一个节点
            {
                TrieNode *node= new TrieNode();
                node->content=word[i];
                node->end=true;
                p->to.push_back(node);
                p=node;
            }
        }
    }

    int search(string word) {
        TrieNode *p=root;
        int len=word.length();
        for(int i=0;i<len;i++){
            int lenofto=p->to.size();
            int yes=-1;
            for(int j=0;j<lenofto;j++){
                if(p->to[j]->content==word[i]){
                    yes=j;
                    break;
                }
            }
            if(yes!=-1)
            {
                p=p->to[yes];
                if(i==len-1 && p->end)
                    return 3;
                else if(i==len-1)
                    return 2;
            }
            else
                return -1;
        }
        return -1;
        
    }

private:
    TrieNode* root;
};
class Solution {
private:
    Trie wl;
    unordered_set<string> r;
public:
    void dfs(vector<vector<char>>& board, vector<vector<bool>> &visit, string form,int x, int y)
    {
        if(x<0 || x>=board.size() ||y<0|| y>=board[0].size()||visit[x][y])
            return ;
        form+=board[x][y];
        int s= wl.search(form);
        if(s==-1)
            return ;
        if(s==3)
            r.insert(form);
        visit[x][y]=true;
        dfs(board,visit,form,x+1,y);
        dfs(board,visit,form,x,y+1);
        dfs(board,visit,form,x-1,y);
        dfs(board,visit,form,x,y-1);
        visit[x][y]=false;
    }    
    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        for(int i=0;i<words.size();i++)
            wl.insert(words[i]);
        vector<vector<bool>> visit;
        vector<bool> v;
        for(int i=0;i<board[0].size();i++)
            v.push_back(false);
        for(int i=0;i<board.size();i++)
            visit.push_back(v);
        string n;
        for(int x=0;x<board.size();x++)
            for(int y=0;y<board[0].size();y++)
                dfs(board,visit,n,x,y);
        vector<string> re;
        copy(r.begin(),r.end(),back_inserter(re));
        return re;
    }
};