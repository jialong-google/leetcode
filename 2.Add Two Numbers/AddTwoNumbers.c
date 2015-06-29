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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* l1l=l1;
        ListNode* l2l=l2;
        ListNode* tmp=NULL;
        bool get=false;
        int count=0;
        for(;l1l->next!=NULL;l1l=l1l->next){
            count++;
        }
        for(;l2l->next!=NULL;l2l=l2l->next){
            count--;
        }
        if(count<0){
            tmp=l1;
            l1=l2;
            l2=tmp;
            tmp=l1l;
            l1l=l2l;
            l2l=tmp;
        }//总之是要l1更长
        l1l->next=l2;
        ListNode* ll1=l1;
        ListNode* ll2=l2;
        while(ll1!=l2 && ll2!=NULL){
            ll1->val=ll2->val+ll1->val;
            printf("%d\n",ll1->val);
            if(get==true){
                ll1->val=ll1->val+1;
                get=false;
            }
            if(ll1->val>=10)
            {
                ll1->val=ll1->val%10;
                get=true;
            }
            ll1=ll1->next;
            ll2=ll2->next;
        }
        if(ll1==l2 && ll2==NULL)
        {
            if(get==true){
                ll1->val=1;
                ll1->next=NULL;
            }
            else{
                l1l->next=NULL;
            }
            return l1;
        }
        else if(ll1!=l2 && ll2==NULL){
            while(get==true && ll1!=l2){
                ll1->val++;
                get=false;
                if(ll1->val >= 10)
                {
                    get=true;
                    printf("%d\n",ll1->val);
                    ll1->val=ll1->val%10;
                    ll1=ll1->next;
                }
            }
            if(get==true && ll1==l2){
                ll1->val=1;
                ll1->next=NULL;
                return l1;
            }
            
            l1l->next=NULL;
        }
        
        return l1;
    }
};
