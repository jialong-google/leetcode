# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseBetween(self, head, m, n):
        """
        :type head: ListNode
        :type m: int
        :type n: int
        :rtype: ListNode
        """
        diff=n-m
        dummy=ListNode(-1)
        dummy.next=head
        nodeprev=dummy
        while m>1:
            nodeprev=nodeprev.next
            m-=1
        nodelater=nodeprev.next
        while diff:
            nodelater=nodelater.next
            diff-=1
        returnlater=nodelater.next
        (newhead,newtail)=self.reverseNodetoNode(nodeprev.next,nodelater)
        nodeprev.next=newhead
        newtail.next=returnlater
        return dummy.next
        
    def reverseNodetoNode(self,head,tail):
        if not head or not tail:
            return (head,tail)
        prev=None
        mid=head
        later=mid.next
        while not mid==tail:
            mid.next=prev
            prev=mid
            mid=later
            later=later.next
        mid.next=prev
        return (mid,head)