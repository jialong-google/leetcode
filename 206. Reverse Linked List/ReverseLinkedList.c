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
    ListNode* reverseList(ListNode* head) {
        ListNode *rhead;
        ListNode * p=head;
        ListNode *next;
        if(p!=NULL)
            next=head->next;
        if(p==NULL ||next==NULL)
        {
            return p;
        }
        while(next->next!=NULL)
        {
            p=p->next;
            next=next->next;
        }
        rhead=next;
        next->next=p;
        while(1)
        {
            next=p;
            p=head;
            if(next==head)
            {
                next->next=NULL;
                return rhead;
            }
            while(p->next!=next)
                p=p->next;
            if(p==head){
                next->next=p;
                p->next=NULL;
                return rhead;
            }
            next->next=p;
        }
    }
};