/**
 * Definition for singly-linked list with a random pointer.
 * struct RandomListNode {
 *     int label;
 *     RandomListNode *next, *random;
 *     RandomListNode(int x) : label(x), next(NULL), random(NULL) {}
 * };
 */
class Solution {
public:

    int count(RandomListNode *head, RandomListNode *l){
        //count from head to l;
        int i=0;
        if(l!=NULL){
            for(;head!=l;head=head->next){
                i++;
            }
        }
        if(head!=l)
            return -1;
        else
            return i;
    }
    
    RandomListNode *copyRandomList(RandomListNode *head) {
        RandomListNode * myhead=NULL;
        RandomListNode * myl=myhead;
        RandomListNode * l=head;
        //next field's copy.
        l=head;
        while(l!=NULL){
            RandomListNode *p=new RandomListNode(l->label);
            if(myhead==NULL)
            {    
                myhead=p;
                myl=myhead;
            }
            else
            {
                myl->next=p;
                myl=myl->next;
            }
            l=l->next;
        }
        l=head;
        myl=myhead;
        
        while(l!=NULL){
            //copy random field.
            int c=count(head,l->random);
            if(c!=-1){
                RandomListNode *next1=myhead;
                for(int n=0;n!=c;n++){
                    next1=next1->next;
                }
                myl->random=next1;
            }
            l=l->next;
            myl=myl->next;
        }
        
        return myhead;
    }
};
