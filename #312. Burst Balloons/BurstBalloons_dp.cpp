class Solution {
public:
    int maxCoins(vector<int>& nums) {
        int len= nums.size();
        int n[len+2];
        n[0]=1;
        n[len+1]=1;
        for(int i=1;i<len+1;i++)
            n[i]=nums[i-1];
            
        int dp[len+2][len+2];
        for(int i=0;i<len+2;i++)
            for(int j=0;j<len+2;j++)
                dp[i][j]=0;

        for(int k=2;k<=len+1;k++){
            for(int left=0;left<=len-k+1;left++){
                int right=left+k;
                for(int m=left+1;m<right;m++)
                    dp[left][right]=max(dp[left][right], n[left]*n[m]*n[right]+dp[left][m]+dp[m][right]);
            }
        }
        return dp[0][len+1];
    }
};