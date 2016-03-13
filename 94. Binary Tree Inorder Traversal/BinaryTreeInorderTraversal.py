# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root:
            return []
        stack=[]
        pointerofdealing=root
        stack.append(pointerofdealing)
        ans=[]
        nodehasbeenvisited=[]
        while stack:
            pointerofdealing=stack.pop()
            if pointerofdealing not in nodehasbeenvisited:
                if pointerofdealing.left:
                    stack.append(pointerofdealing)
                    stack.append(pointerofdealing.left)
                    nodehasbeenvisited.append(pointerofdealing)
                    #pointerofdealing.left=None
                    continue
            ans.append(pointerofdealing.val)
            if pointerofdealing.right:
                stack.append(pointerofdealing.right)
                continue
        return ans