class Solution(object):
    def subsetsWithDup(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        resolution=[]
        def dfs(nums,index,valuelist):
            if valuelist not in resolution:
                resolution.append(valuelist)
            if index==len(nums):
                return
            dfs(nums,index+1,valuelist)
            dfs(nums,index+1,valuelist+[nums[index]])
        nums.sort()
        dfs(nums,0,[])
        return resolution