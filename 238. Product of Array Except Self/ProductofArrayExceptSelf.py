class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        if not nums:
            return nums
        accu1=accu2=1
        result=[1]* len(nums)
        for index in range(1,len(nums)):
            accu1*=nums[index-1]
            result[index]*=accu1
        for index in range(0,len(nums)-1)[::-1]:
            accu2*=nums[index+1]
            result[index]*=accu2
        return result