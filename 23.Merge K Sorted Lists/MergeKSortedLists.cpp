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

    ListNode* mergeTwoLists(ListNode* list1,ListNode* list2)
    {
        ListNode *l= new ListNode(-1);
        ListNode *rear=l;
        
        while(list1!=NULL && list2!=NULL){
            if(list1->val <= list2->val)//将小的插入到l表尾部
            {    
                rear->next=list1;
                list1=list1->next;
            }
            else
            {
                rear->next=list2;
                list2=list2->next;
            }
            //printf("%d ",rear->val);
            rear=rear->next;
        }
        if(list1== NULL){
            rear->next =list2;
        }
        else//list2==NULL
        {
            rear->next=list1;
        }
        //printf("\n");
        return l->next;
    }
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        if(lists.size()==0)
            return NULL;
        else if(lists.size()==1)
            return lists.front();
        //else if(lists.size()==2)
        //    return mergeTwoLists(lists.begin(),lists.end());
        else{//分成两半 递归后归并。
            vector<ListNode*> l1(lists.begin(),lists.begin()+lists.size()/2);
            vector<ListNode*> l2(lists.begin()+lists.size()/2,lists.end());
            ListNode * lists1=mergeKLists(l1);//前一半
            ListNode * lists2=mergeKLists(l2);//后一半
            return mergeTwoLists(lists1,lists2);
        }
    }
};
