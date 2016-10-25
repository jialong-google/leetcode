/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pointer = dummy;
        while(pointer != null && pointer.next != null)
        {
            while(pointer.next != null && pointer.next.val == val)
            {
                pointer.next = pointer.next.next;
            }
            pointer = pointer.next;
        }
        return dummy.next;
    }
}