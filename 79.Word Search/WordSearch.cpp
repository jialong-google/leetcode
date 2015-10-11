class Solution {
public:
    int dir[4][2]={ {0,1}, {0,-1}, {-1,0} , {1,0} };
    bool search(vector<vector<char>> &board, int p_y,int p_x, string word, vector<vector<bool>> &bitmap){
        if(word.length()==0)
            return true;
        int n_y;
        int n_x;
        for(int i=0;i<4;i++){
            n_y=p_y+dir[i][0];
            n_x=p_x+dir[i][1];
            if(n_y>=0 && n_x>=0 && n_y<board.size() && n_x<board[0].size() && bitmap[n_y][n_x]==false && board[n_y][n_x]==word[0])//如果地址合法&&没有被访问过&&匹配下一个字母。
            {
                bitmap[n_y][n_x]=true;
                if( search(board,n_y,n_x,word.substr(1),bitmap))//return search,then goes wrong!!如果直接return 就会断送遍历的其他路径。
                    return true;
                bitmap[n_y][n_x]=false;
            }
        }
        return false;
    }

    bool exist(vector<vector<char>>& board, string word) {
        if(word.empty())
            return false;
        
        int y=board.size();
        int x=board[0].size();
        vector<vector<bool>> bitmap;
        vector<bool> tmp;
        for(int j=0;j<x;j++)
            tmp.push_back(false);
        for(int i=0;i<y;i++)
            bitmap.push_back(tmp);
        
        for(int i=0;i<y;i++)
            for(int j=0;j<x;j++)
            {
                if(board[i][j]==word[0]){
                    bitmap[i][j]=true;
                    if(search(board,i,j,word.substr(1),bitmap))
                        return true;
                    else
                        bitmap[i][j]=false;
                }
            }
        return false;
    }
};