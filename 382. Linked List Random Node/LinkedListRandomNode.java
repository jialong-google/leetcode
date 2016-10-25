/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//need to practice the skill to explain why this problem get solved. 
//And why this can generate a same probability solution.
public class Solution {

    private ListNode head;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int var = head.val;
        ListNode iter = head;
        int i = 0;
        while(iter != null)
        {
            i ++;
            int rand = (int)(Math.random() * i);// the brace here is necessary because otherwise the convertion begins first.
            if(rand == 0)
            {
                var = iter.val;
            }
            iter = iter.next;
        }
        return var;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */