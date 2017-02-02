/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head == null)
            return head;
        //ListNode dummy = new ListNode(-1);
        //dummy.next = head;
        ListNode current = head;
        int count = 0;
        while(count != k && current != null)
        {
            current = current.next;
            count ++;
        }
        if(count == k)
        {
            current = reverseKGroup(current, k);
            while(count -- > 0)
            {
                ListNode temp = head.next;
                head.next = current;
                current = head;
                head = temp;
            }
            head = current;
        }
        return head;
    }
}