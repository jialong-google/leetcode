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
        heap=[]
        for i in lists:
            if i is not None:
                heap.append((i.val,i))
        heapq.heapify(heap)
        current=ListNode(-1)
        head=current
        while(heap):
            v=heapq.heappop(heap)
            current.next=v[1]
            current=current.next
            if v[1].next:
                heapq.heappush(heap,(v[1].next.val,v[1].next))
        return head.next