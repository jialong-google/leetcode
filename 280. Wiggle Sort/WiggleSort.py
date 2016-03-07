class Solution(object):
    def wiggleSort(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        if not nums or len(nums)==1:
            return
        prev,mid=nums[0],nums[1]
        up=True
        if prev>mid:
            nums[0],nums[1]=nums[1],nums[0]
            prev,mid=mid,prev
        for i in range(2,len(nums)):
            up=not up
            if not up:#down!!!!!!!!!!!!!!!!!!!!!!
                if(prev<=mid<nums[i]):
                    nums[i-1],nums[i]=nums[i],nums[i-1]
            else:#up!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                if(prev>=mid>nums[i]):
                    nums[i-1],nums[i]=nums[i],nums[i-1]
            prev,mid=nums[i-1],nums[i]
                