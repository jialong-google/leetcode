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

    void swap(ListNode** l1,ListNode **l2){
        if(*l1==NULL ||*l2==NULL)
            return ;
        ListNode *lx1=*l1;
        *l1=*l2;
        *l2=(*l1)->next;
        (*l1)->next=lx1;
    }
    ListNode* swapPairs(ListNode* head) {
        
        if(head!=NULL && head->next!=NULL)
        {
            swap(&head,&head->next);
            ListNode *l=head->next;
            while(l!=NULL && l->next!=NULL &&l->next->next!=NULL)
            {
                swap(&l->next,&l->next->next);
                if(l->next==NULL || l->next->next==NULL)
                    return head;
                else
                    l=l->next->next;
            }
        }
        return head;
    }
};
