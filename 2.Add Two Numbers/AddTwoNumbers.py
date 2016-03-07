# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        carry=0
        head1=l1
        head2=l2
        
        while head1.next and head2.next:
            r=head1.val+head2.val+carry
            head1.val,carry=r%10,r/10
            head1=head1.next
            head2=head2.next
        val=head1.val+head2.val+carry
        head1.val,carry= val%10,val/10
        if carry and not head1.next and not head2.next:
            head1.next=l2
            l2.next=None
            l2.val=1
            return l1
        if head1.next:
            head1=head1.next
            while head1.next and carry:
                val=head1.val+carry
                head1.val,carry=val%10,val/10
                head1=head1.next
            if carry:
                val=head1.val+carry
                head1.val,carry=val%10,val/10
                if carry:
                    head1.next=l2
                    l2.next=None
                    l2.val=1
            return l1
        if head2.next:
            head2=head2.next
            head1.next=head2
            while carry and head2.next:
                val=head2.val+carry
                head2.val,carry=val%10,val/10
                head2=head2.next
            head1=head2
            if carry:
                val=head2.val+carry
                head2.val,carry=val%10,val/10
                if carry:
                    head2.next=l2
                    l2.next=None
                    l2.val=1
            return l1
        return l1
            