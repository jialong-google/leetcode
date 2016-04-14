# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def generateTrees(self, n):
        """
        :type n: int
        :rtype: List[TreeNode]
        """
        #ListofTrees=[None for i in range(n)]
        if n==0:
            return []
        def dfs(start,end):
            if start>end:
                return [None]
            l=[]
            for i in range(start,end+1):
                lefttrees=dfs(start,i-1)
                righttrees=dfs(i+1,end)
                for j in lefttrees:
                    for k in righttrees:
                        node=TreeNode(i)
                        node.left=j
                        node.right=k
                        l.append(node)
            return l
        return dfs(1,n)
        