class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        dp=[0]+[99999]*amount
        i=0
        coins.sort()
        while i<=amount:
            for coin in coins:
                if i+coin<=amount:
                    dp[i+coin]=min(dp[i+coin],dp[i]+1)
            i+=1
            #i+=coins[0]
        if dp[amount]==99999:
            return -1
        else:
            return dp[amount]