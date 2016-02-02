class Solution {
    int len1;
    int len2;
public:
    unordered_map<int,unordered_set<int>> s;
    bool canchange(vector<vector<char>>& board, int i,int j)
    {
        if((i>=len1-1 ||j>=len2-1 ||j<=0 ||i<=0)&& board[i][j]=='O')
        {
            return false;
        }
        else if(board[i][j]=='X')
            return true;
        else{
            if(!(i>len1-1 ||j>len2-1 ||j<0 ||i<0) && s[i].find(j)!=s[i].end())
                return true;
            else
                s[i].insert(j);
            if(canchange(board,i+1,j)&&canchange(board,i-1,j)&&canchange(board,i,j+1)&&canchange(board,i,j-1))
                return true;
            else
            {
                s.clear();
                return false;
            }
        }
    }
    void solve(vector<vector<char>>& board) {
        if(board.empty()||board[0].empty())
            return ;
        len1=board.size();
        len2=board[0].size();
        for(int i=0;i<len1;i++)
            for(int j=0;j<len2;j++)
            {
                if(board[i][j]=='O' && canchange(board,i,j))
                    board[i][j]='X';
            }
    }
};