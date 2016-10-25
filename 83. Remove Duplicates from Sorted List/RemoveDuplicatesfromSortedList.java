/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode one = head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        while(one != null)
        {
            ListNode two = one.next;
            while(two != null && two.val == one.val)
            {
                two = two.next;
            }
            one.next = two;
            one = one.next;
        }
        return dummy.next;
        
    }
}