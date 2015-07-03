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
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode *l= new ListNode(-1);
        ListNode *rear=l;
        
        while(l1!=NULL && l2!=NULL){
            if(l1->val <= l2->val)//将小的插入到l表尾部
            {    
                rear->next=l1;
                l1=l1->next;
            }
            else
            {
                rear->next=l2;
                l2=l2->next;
            }
            rear=rear->next;
        }
        if(l1== NULL){
            rear->next =l2;
        }
        else//list2==NULL
        {
            rear->next=l1;
        }
        return l->next;
    }
};
