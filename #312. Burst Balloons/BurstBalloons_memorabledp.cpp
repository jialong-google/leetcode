class Solution {

public:
    
    int maxCoins(vector<int>& nums) {
        int len=nums.size();
        nums.insert(nums.begin(),1);
        nums.insert(nums.end(),1);
        vector<vector<int>> dp(len+2,vector<int> (len+2,0));
        return DP(1,len,dp,nums);
    }
    
    int DP(int i,int j, vector<vector<int >> &dp, vector<int>& nums){
        if(dp[i][j]>0)
            return dp[i][j];
        for(int p=i;p<=j;p++){
            int temp=DP(i,p-1,dp,nums)+nums[i-1]*nums[p]*nums[j+1]+DP(p+1,j,dp,nums);
            if(temp>dp[i][j])
                dp[i][j]=temp;
        }
        return dp[i][j];
    }
};