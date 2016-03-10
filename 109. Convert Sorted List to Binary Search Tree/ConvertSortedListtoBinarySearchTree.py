# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def sortedListToBST(self, head):
        """
        :type head: ListNode
        :rtype: TreeNode
        """
        if (not head) or (not head.next):
            return head
        node=head
        array=[]
        while node:
            array.append(node.val)
            node=node.next
        def arrayToBST(prev,later):
            if prev>later:
                return None
            num=(prev+later)/2
            node=TreeNode(array[num])
            node.left=arrayToBST(prev,num-1)
            node.right=arrayToBST(num+1,later)
            return node
        return arrayToBST(0,len(array)-1)
            
        