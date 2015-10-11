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
    void swap(ListNode *front,ListNode *rear){
        ListNode * tmp=front->next; 
        ListNode * next=NULL;
        while(front!=rear)
        {
            next=tmp->next;
            tmp->next=front;
            front=tmp;
            tmp=next;
        }
    }
    
    ListNode* reverseKGroup(ListNode* head, int k) {
        if(head == NULL)
            return head;
        ListNode myhead(-1);
        myhead.next=head;
        ListNode* rear=head;
        for(int i=1;i<k && rear!=NULL;i++)
            rear=rear->next;
        if(rear==NULL)
            return head;
        ListNode* prev= &myhead;
        ListNode* next=rear->next;
        ListNode* front=head;
        while(rear!=NULL){
            swap(front,rear);
            prev->next=rear;
            front->next=next;
            prev=front;
            front=next;
            rear=next;
            for(int i=1;i<k && rear!=NULL;i++)
                rear=rear->next;
            if(rear!=NULL)
                next=rear->next;
        }
        return myhead.next;
    }
};
