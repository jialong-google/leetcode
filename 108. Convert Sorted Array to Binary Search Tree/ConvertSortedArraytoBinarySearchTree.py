# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def sortedArrayToBST(self, nums):
        """
        :type nums: List[int]
        :rtype: TreeNode
        """
        def helper(nums,i,j):
            if i<=j:
                mid=(i+j)/2
                midNode=TreeNode(nums[mid])
                midNode.left=helper(nums,i,mid-1)
                midNode.right=helper(nums,mid+1,j)
                return midNode
            return None
        return helper(nums,0,len(nums)-1)