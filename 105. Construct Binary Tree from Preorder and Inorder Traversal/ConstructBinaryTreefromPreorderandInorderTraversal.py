# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        if not preorder or not inorder:
            return None
        node=TreeNode(preorder[0])
        mid=inorder.index(preorder[0])
        del preorder[0]
        node.left=self.buildTree(preorder,inorder[:mid])
        node.right=self.buildTree(preorder,inorder[mid+1:])
        return node