class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        self.mini=999999
        
        def dfs(numofcoins,amountleft):
            if amountleft==0:
                self.mini=min(numofcoins,self.mini)
                return
            if amountleft<0:
                return
            for i in coins[::-1]:
                if amountleft-i>=0:
                    dfs(numofcoins+1,amountleft-i)
                    return
        dfs(0,amount)
        if self.mini==999999:
            return -1
        return self.mini

s=Solution()
print s.coinChange([1,2,5],40)