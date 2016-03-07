class Solution(object):
    
    def quickselectmid(self,nums,prev,later,k):
        if prev>=later:
        	return prev
        pivot=prev
        i=prev
        j=later
        while(i<j):
            while(nums[i]<=nums[pivot] and i<j):
                i=i+1
            while(nums[j]>nums[pivot] and i<j):
                j=j-1
            if(i<j):
                nums[i],nums[j]=nums[j],nums[i]
        if(nums[i]>nums[pivot]):
        	nums[i-1],nums[pivot]=nums[pivot],nums[i-1]
        	pivot=i-1
        else:
            nums[i],nums[pivot]=nums[pivot],nums[i]
            pivot=i
        if(pivot+1==k):
        	return pivot
        elif(pivot+1>k):
            return self.quickselectmid(nums,prev,pivot-1,k)
        else:
        	return self.quickselectmid(nums,pivot+1,later,k-pivot-1)

    def wiggleSort(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        k=len(nums)/2+1
        pivot=self.quickselectmid(nums,0,len(nums)-1,k)
        med = (len(nums) - 1) / 2
        nums[::2], nums[1::2] = nums[med::-1], nums[:med:-1]