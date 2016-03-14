class Solution(object):
    def combinationSum2(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        ans=[]
        candidates.sort()
        def dfs(candidates,target,valuelist,j):
            if target==0 and valuelist not in ans:
                ans.append(valuelist)
                return
            for i in range(j,len(candidates)):
                if target>=candidates[i]:
                    dfs(candidates[:i]+candidates[i+1:],target-candidates[i],valuelist+[candidates[i]],i)
                else:
                    break
        dfs(candidates,target,[],0)
        return ans