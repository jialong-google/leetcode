class Solution {
    int len1;
    int len2;
public:
    stack<pair<int ,int >> s;
    void flooding(vector<vector<char>>& board, int i, int j)
    {
        s.push(make_pair(i,j));
        while(!s.empty())
        {
            int i=s.top().first;
            int j=s.top().second;
            s.pop();
            if(i>=0&&j>=0&&i<len1&&j<len2&& board[i][j]=='O')
            {
                board[i][j]='Y';
                if(i+1<len1)
                    s.push(make_pair(i+1,j));
                if(j+1<len2)
                    s.push(make_pair(i,j+1));
                if(i-1>=0)
                    s.push(make_pair(i-1,j));
                if(j-1>=0)
                    s.push(make_pair(i,j-1));
            }
        }
    }
    void solve(vector<vector<char>>& board) {
        if(board.empty()||board[0].empty())
            return ;
        len1=board.size();
        len2=board[0].size();
        for(int i=0;i<len1;i++)
        {
            if(board[i][0]=='O')
                flooding(board,i,0);
            if(board[i][len2-1]=='O')
                flooding(board,i,len2-1);
        }
        for(int j=0;j<len2;j++)
        {
            if(board[0][j]=='O')
                flooding(board,0,j);
            if(board[len1-1][j]=='O')
                flooding(board,len1-1,j);
        }
        for(int i=0;i<len1;i++)
            for(int j=0;j<len2;j++)
            {
                if(board[i][j]=='Y')
                    board[i][j]='O';
                else if(board[i][j]=='O')
                    board[i][j]='X';
            }
    }
};