# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        if not root:
            return -1
        stack=[]
        p=root
        while(p):
            stack.append(p)
            p=p.left
        x=1
        
        while stack and x<=k:
            p=stack.pop()
            x+=1
            p1=p.right
            while p1:
                stack.append(p1)
                p1=p1.left
        return p.val