# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        if not root or root==p or root==q:
            return root
        r1=self.lowestCommonAncestor(root.left,p,q)
        r2=self.lowestCommonAncestor(root.right,p,q)
        if not r1 and not r2:
            return None
        elif r1 and not r2:
            return r1
        elif not r1 and r2:
            return r2
        else:
            return root
        