class Solution {
public:
    int calculateMinimumHP(vector<vector<int>>& dungeon) {
        int n = dungeon.size();
        int m = dungeon[0].size();
        int dp[n][m];
        dp[n-1][m-1]=max(-dungeon[n-1][m-1]+1,1);
        for(int i=n-2;i>=0;i--){
            dp[i][m-1]=max(1,dp[i+1][m-1]-dungeon[i][m-1]);
        }
        for(int j=m-2;j>=0;j--){
            dp[n-1][j]=max(1,dp[n-1][j+1]-dungeon[n-1][j]);
        }
        for(int j=m-2;j>=0;j--)
            for(int i=n-2;i>=0;i--)
                dp[i][j]=max(1,min(dp[i+1][j],dp[i][j+1])-dungeon[i][j]);
        return dp[0][0];
    }
};