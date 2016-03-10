class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        self.ans=[]
        def dfs(num_remain,valuelist):
            #print valuelist
            if not num_remain:
                self.ans.append(valuelist)
            for index in range(len(num_remain)):
                dfs(num_remain[:index]+num_remain[index+1:],valuelist+[num_remain[index]])
        dfs(nums,[])
        return self.ans