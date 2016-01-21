/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        int alen=0;
        int blen=0;
        ListNode *p1=headA;
        ListNode *p2=headB;
        while(p1!=NULL)
        {
            alen++;
            p1=p1->next;
        }
        while(p2!=NULL)
        {
            blen++;
            p2=p2->next;
        }
        int l=alen-blen;
        p1=headA;
        p2=headB;
        if(l>0)// b is shorter.
            while(l--!=0)
                p1=p1->next;
        else// a is shorter or the same
            while(l++!=0)
                p2=p2->next;
        while(p1!=NULL && p1->val!=p2->val)
        {
            p1=p1->next;
            p2=p2->next;
        }
        if(p1==NULL)
            return NULL;
        else
            return p1;
        
    }
};