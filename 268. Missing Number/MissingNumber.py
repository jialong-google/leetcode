class Solution(object):
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        memeda=0
        for i in nums:
            memeda=memeda^i
        for i in range(len(nums)+1):
            memeda=memeda^i
        return memeda