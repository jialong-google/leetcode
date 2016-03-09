class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        resolution=[]
        def dfs(nums,i,strnow):
            s=sorted(strnow)
            if s not in resolution:
                resolution.append(s)
            if i==len(nums):
                return
            dfs(nums,i+1,strnow+[nums[i]])
            dfs(nums,i+1,strnow)
        dfs(nums,0,[])
        return resolution