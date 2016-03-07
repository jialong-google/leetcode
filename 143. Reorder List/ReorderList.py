# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: void Do not return anything, modify head in-place instead.
        """
        #first to find the mid node.
        fast=head
        slow=head
        if not slow or slow.next==None:
            return
        while(fast and slow and fast.next):
            slow=slow.next
            fast=fast.next.next
        slow_ahead=slow.next
        
        if not slow.next==None:
            slow.next=None
            slow_ahead_two=slow_ahead.next
            while(slow_ahead_two):
                slow_ahead.next=slow
                slow=slow_ahead
                slow_ahead=slow_ahead_two
                slow_ahead_two=slow_ahead_two.next
            slow_ahead.next=slow
            modifier=head
            while not slow_ahead.next==None:
                modifiernext=modifier.next
                modifier.next=slow_ahead
                slownext=slow_ahead.next
                slow_ahead.next=modifiernext
                modifier=modifiernext
                slow_ahead=slownext
        
        