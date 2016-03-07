# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if not head or head.next==None:
            return False
        fast=head.next
        slow=head
        while not(fast==None or slow==None):
            if fast==slow:
                return True
            fast=fast.next
            if not fast==None:
                fast=fast.next
            slow=slow.next
        return False