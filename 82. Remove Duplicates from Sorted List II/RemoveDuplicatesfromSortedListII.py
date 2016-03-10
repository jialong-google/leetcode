# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head:
            return head
        dummy=ListNode(-1)
        dummy.next=head
        prev,mid,later=dummy,head,head.next
        while(later):
            while later and later.val==mid.val:
                later=later.next
            if not mid.next==later:
                prev=self.deletenodeinbetween(prev,later)
                if prev.next:
                    mid=prev.next
                    later=mid.next
            else:
                prev,mid,later=mid,later,later.next
        return dummy.next
    def deletenodeinbetween(self,prev,later):#nodes in between prev and later are deleted.
        if not later:
            prev.next=None
            return prev
        prev.next=later
        return prev