class Solution(object):
    def minSubArrayLen(self, s, nums):
        """
        :type s: int
        :type nums: List[int]
        :rtype: int
        """
        ans=len(nums)+1
        start=0
        end=0
        sum=0
        while end<len(nums):
            #end++
            while end<len(nums) and sum<s:
                sum+=nums[end]
                end+=1
            while start<end and sum>=s:
                ans=min(ans,end-start)
                sum-=nums[start]
                start+=1
            #start++
        if ans==len(nums)+1:
            return 0
        return ans