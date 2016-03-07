class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        #S=[0 for i in range(nums)]
        m=-sys.maxint-1
        sum=0
        for i in nums:
            if(sum<0):
                sum=0
            sum+=i
            m=max(m,sum)
        return m