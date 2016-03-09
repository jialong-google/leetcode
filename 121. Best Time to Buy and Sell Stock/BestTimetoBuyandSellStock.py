class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if not prices:
            return 0
        resolution=0
        curMin=prices[0]
        for index in range(len(prices)):
            curMin=min(prices[index],curMin)
            resolution=max(prices[index]-curMin,resolution)
        return resolution
        