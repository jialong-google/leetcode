# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def countNodes(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.count=0
        return self.countcompleteTree(root)
    def countcompleteTree(self,root):
        if not root:
            return 0
        count_left,count_right=0,0
        node=root.left
        while(node):
            count_left+=1
            node=node.left
        node=root.right
        while(node):
            count_right+=1
            node=node.right
        if count_left==count_right:
            return 2**(count_left+1)-1
        else:
            return 1+self.countcompleteTree(root.left)+self.countcompleteTree(root.right)