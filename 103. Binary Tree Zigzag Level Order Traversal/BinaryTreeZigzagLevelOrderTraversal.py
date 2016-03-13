# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def zigzagLevelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if not root:
            return []
        stack1=[root]
        stack2=[]
        ans=[]
        while stack1 or stack2:
            tmp=[]
            while stack1:
                node=stack1.pop()
                tmp.append(node.val)
                if node.left:
                    stack2.append(node.left)
                if node.right:
                    stack2.append(node.right)
            if tmp:
                ans.append(tmp)
            tmp=[]
            while stack2:
                node=stack2.pop()
                tmp.append(node.val)
                if node.right:
                    stack1.append(node.right)
                if node.left:
                    stack1.append(node.left)
            if tmp:
                ans.append(tmp)
        return ans