# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        if not lists or len(lists) == 0:
            return None
        elif len(lists) == 1:
            return lists[0]
        elif len(lists) == 2:
            return self.mergeTwoLists(lists[0],lists[1])
        else:
            half = len(lists) / 2
            return self.mergeTwoLists(self.mergeKLists(lists[:half]), self.mergeKLists(lists[half:]))
        
    def mergeTwoLists(self, l1, l2):
        if not l1 and not l2:
            return None
        dummy = cur = ListNode(0)
        
        while l1 and l2:
            if l1.val < l2.val:
                cur.next = l1
                l1 = l1.next
                cur = cur.next
            else:
                cur.next = l2
                l2 = l2.next
                cur = cur.next
        cur.next = l1 or l2
        return dummy.next