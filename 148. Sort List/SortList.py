# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def sortList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if (not head )or (not head.next):
            return head
        dummy=ListNode(-1)
        dummy.next=head
        fast=dummy
        slow=dummy
        while(fast and fast.next):##!!!
            slow=slow.next
            fast=fast.next
            if fast:
                fast=fast.next
            else:
                break
        head1=head
        head2=slow.next
        slow.next=None
        head1 = self.sortList(head1)
        head2= self.sortList(head2)
        head=self.mergetwo(head1,head2)
        return head
        
    def mergetwo(self,head1,head2):
        if not head1:
            return head2
        if not head2:
            return head1
        dummy=ListNode(-1)
        node=dummy
        while(head1 and head2):
            if head1.val<head2.val:
                node.next=head1
                head1=head1.next
                node=node.next
            else:
                node.next=head2
                head2=head2.next
                node=node.next
        if head1:
            node.next=head1
        if head2:
            node.next=head2
        return dummy.next
                