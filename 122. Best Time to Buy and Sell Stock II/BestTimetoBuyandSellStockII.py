class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if not prices:
            return 0
        ans=0
        prev=prices[0]
        for index in range(1,len(prices)):
            cur=prices[index]
            if cur>prev:
                ans+=cur-prev
            prev=cur
        return ans