class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        memeda=0
        for i in nums:
            memeda=memeda^i
        return memeda