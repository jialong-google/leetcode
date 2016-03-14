# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        if not inorder:
            return None
        topvalue=postorder.pop()
        Node=TreeNode(topvalue)
        mid=inorder.index(topvalue)
        Node.right=self.buildTree(inorder[mid+1:],postorder)
        Node.left=self.buildTree(inorder[:mid],postorder)
        return Node
        