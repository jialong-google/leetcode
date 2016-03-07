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
        tmp, l1.val = divmod(l1.val + l2.val, 10)
        r = l1

        while (l1.next and l2.next):
            tmp, l1.next.val = divmod(l1.next.val + l2.next.val + tmp, 10)
            l1 = l1.next
            l2 = l2.next
        if l2.next:
            l1.next = l2.next
        while l1.next and tmp:
            tmp, l1.next.val = divmod(l1.next.val + tmp, 10)
            l1 = l1.next
        if tmp:
            l1.next = ListNode(1)
        return r