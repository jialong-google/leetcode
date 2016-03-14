# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def insertionSortList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head:
            return head
        dummy=ListNode(-1)
        dummy.next=head
        current=head
        while current.next:
            if current.next.val<current.val:
                deal=current.next
                current.next=deal.next
                pre=dummy
                while pre.next.val<deal.val:
                    pre=pre.next
                r=pre.next
                deal.next=r
                pre.next=deal
            else:
                current=current.next
        return dummy.next