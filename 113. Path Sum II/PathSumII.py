# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]
        """
        self.ans=[]
        def dps(node,sumonepath,valuelist):
            if not node:
                return
            if (not node.left)and(not node.right): 
                if sumonepath+node.val==sum :
                    self.ans.append(valuelist+[node.val])
                    return
            dps(node.left,sumonepath+node.val,valuelist+[node.val])
            dps(node.right,sumonepath+node.val,valuelist+[node.val])
        dps(root,0,[])
        return self.ans