class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        def search(nums,target,i,j):
            if i<=j:
                mid=(i+j)/2
            else:
                return -1
            if nums[mid]==target:
                return mid
            elif nums[mid]<target:
                return search(nums,target,mid+1,j)
            elif nums[mid]>target:
                return search(nums,target,i,mid-1)
        m=search(nums,target,0,len(nums)-1)
        if m==-1:
            return [-1,-1]
        left=m
        right=m
        while left>=0 and nums[left]==nums[m]:
            left-=1
        while right<len(nums) and nums[right]==nums[m]:
            right+=1
        return [left+1,right-1]