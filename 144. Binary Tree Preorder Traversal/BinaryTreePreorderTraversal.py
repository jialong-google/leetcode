# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root:
            return []
        stack=[root]
        ans=[]
        while stack:
            deal=stack.pop()
            ans.append(deal.val)
            if deal.right:
                stack.append(deal.right)
            if deal.left:
                stack.append(deal.left)
        return ans
        