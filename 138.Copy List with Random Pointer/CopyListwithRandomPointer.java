/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map <RandomListNode,RandomListNode> hash = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode last = dummy;
        while(head!= null)
        {
            RandomListNode cur = hash.get(head);
            if(cur == null)
            {
                cur = new RandomListNode(head.label);
            }
            last.next = cur;
            
            if(head.random != null)
            {
                RandomListNode ran = hash.get(head.random);
                if(ran == null)
                {
                    ran = new RandomListNode(head.random.label);
                }
                cur.random = ran;
            }
            last = last.next;
            head = head.next;
        }
        return dummy.next;
    }
}