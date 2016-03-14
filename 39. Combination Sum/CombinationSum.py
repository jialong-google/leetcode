class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        ans=[]
        def dfs(candidates,target,valuelist,j):
            #valuelist.sort()
            if target==0 and valuelist not in ans:
                ans.append(valuelist)
                return
            for i in range(j,len(candidates)):
                if target-candidates[i]>=0:
                    dfs(candidates,target-candidates[i],valuelist+[candidates[i]],i)
                else:
                    #candidates=candidates[:i]
                    return
        v=[]
        candidates.sort()
        dfs(candidates,target,v,0)
        return ans