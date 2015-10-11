class TrieNode {
public:
    bool end;
    char content;
    vector<TrieNode *> to;
    // Initialize your data structure here.
    TrieNode() {
        
    }
};

class Trie {
public:
    Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    void insert(string word) {
        //先找有没有前缀
        //若有 深入直到没有。
        //若没有 创建节点。
        TrieNode * p=root;
        int len=word.length();
        for(int i=0;i<len;i++){
            //先找有没有前缀
            int yes=-1;
            int lenofto=p->to.size();
            //节点的
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

    // Returns if the word is in the trie.
    bool search(string word) {
        TrieNode *p=root;
        int len=word.length();
        //找到->沿着某一条路径，word遍历完后 找到一节点，此节点是可结束节点。
        //找不到->1.没有某节点 2.找到的节点是不可结束节点。
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
                if(i==len-1 && p->end){
                    return true;
                }
            }
            else
                return false;
        }
        return false;
        
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    bool startsWith(string prefix) {
        TrieNode *p=root;
        int len=prefix.length();
        //找到->沿着某一条路径，word遍历完后 存在一节点。
        //找不到->没有某节点 
        for(int i=0;i<len;i++){
            int lenofto=p->to.size();
            int yes=-1;
            for(int j=0;j<lenofto;j++){
                if(p->to[j]->content==prefix[i]){
                    yes=j;
                    break;
                }
            }
            if(yes!=-1)
            {
                p=p->to[yes];
                if(i==len-1)
                    return true;
            }
            else
                return false;
        }
    }

private:
    TrieNode* root;
};

// Your Trie object will be instantiated and called as such:
// Trie trie;
// trie.insert("somestring");
// trie.search("key");