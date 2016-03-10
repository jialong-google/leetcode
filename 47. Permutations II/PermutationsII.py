class Solution(object):
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        self.ans=[]
        nums.sort()#!!!!!!
        def dfs(valuelist,num_remain):
            if not num_remain:
                self.ans.append(valuelist)
            prev=999
            for index in range(len(num_remain)):
                if num_remain[index]==prev:
                    continue
                prev=num_remain[index]
                dfs(valuelist+[num_remain[index]],num_remain[:index]+num_remain[index+1:])
        dfs([],nums)
        return self.ans