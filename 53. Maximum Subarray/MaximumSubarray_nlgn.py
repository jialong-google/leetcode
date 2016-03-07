class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        m=-sys.maxint-1
        return self.divide(nums,0,len(nums)-1,m)
    
    def divide(self,nums,left,right,m):
        if(left>right):
            return -sys.maxint-1
        mid=(left+right)/2
        ml=self.divide(nums,left,mid-1,m)
        mr=self.divide(nums,mid+1,right,m)
        m=max(max(ml,mr),m)
        mlmax=0
        sum=0
        for i in range(left,mid)[::-1]:
            sum+=nums[i]
            mlmax=max(sum,mlmax)
        mrmax=0
        sum=0
        for i in range(mid+1,right+1):
            sum+=nums[i]
            mrmax=max(sum,mrmax)
        m=max(m,mlmax+mrmax+nums[mid])
        return m