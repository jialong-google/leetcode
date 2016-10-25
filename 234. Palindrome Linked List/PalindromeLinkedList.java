/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSame(ListNode l1, ListNode l2)
    {
        while(l1 != null && l2 != null)
        {
            if(l1.val != l2.val)
            {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 != null || l2 != null)
        {
            return false;
        }
        return true;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        while(fast != null && fast.next != null)
        {
            fast = fast.next;
            if(fast != null)
                fast = fast.next;
            ListNode temp = dummy.next;
            dummy.next = temp.next;
            temp.next = dummy2.next;
            dummy2.next = temp;
        }
        if(isSame(dummy.next, dummy2.next) || isSame(dummy.next, dummy2.next.next))
        {
            return true;
        }
        return false;
    
    }
}