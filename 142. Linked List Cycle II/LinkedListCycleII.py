# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def detectCycle(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head or head.next==None:
            return None
        slow=head
        fast=head
        while not (slow==None or fast==None):
            slow=slow.next
            if not fast.next==None:
                fast=fast.next.next
            else:
                return None
            if slow==fast:
                find_node=head
                while not(find_node==slow):
                    slow=slow.next
                    find_node=find_node.next
                return find_node
        return None