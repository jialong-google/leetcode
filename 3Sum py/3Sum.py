class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        r=[]
        for i in range(len(nums)):
            has={}
            for j in nums[i+1:]:
                if j in has.keys():
                    tmp=[nums[i],j,nums[has[j]]]
                    tmp.sort()
                    if tmp not in r:
                        r.append(tmp)
                else:
                    has[-nums[i]-j]=nums.index(j)
            del has
        return r