# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def rotateRight(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        prob=head
        i=0
        if head==None or head.next==None:
            return head
        while not prob==None:
            prob=prob.next
            i+=1
        k=k%i
        if k==0:
            return head
        
        fast=head
        if fast==None:
            return None
        i=0
        while i<k:
            if fast.next==None:
                break
            else:
                fast=fast.next
            i=i+1
        slow=head
        while not fast.next==None:
            fast=fast.next
            slow=slow.next
        fast.next=head
        head=slow.next
        slow.next=None
        return head