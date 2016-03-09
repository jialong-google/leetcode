class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        if not nums:
            return False
        if len(nums)==1:
            return True
        span=nums[0]
        for index in range(len(nums)):
            if index>=span:
                return False
            elif span<nums[index]+index+1:
                span=nums[index]+index+1
            if span==len(nums):
                return True
        return True