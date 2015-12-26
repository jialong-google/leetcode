/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    void recoverTree(TreeNode* root) {
        TreeNode *prev=NULL;
        TreeNode *n1=NULL;
        TreeNode *n2=NULL;
        TreeNode *current=root;
        while(current!=NULL)
        {
            if(current->left == NULL)
            {
                if(prev!=NULL){
                    if(current->val<prev->val){
                        if(n1==NULL)
                            n1=prev;
                        n2=current;
                    }
                }
                prev=current;
                current=current->right;
            }
            else//current->left!= NULL
            {
                TreeNode *t=current->left;
                while(t->right!=NULL && t->right!=current)
                    t=t->right;
                if(t->right==NULL)
                {
                    t->right=current;
                    current=current->left;
                }
                else
                {
                    t->right=NULL;// restore the tree.
                    if(prev!=NULL){
                        if(current->val<prev->val){
                            if(n1==NULL)
                                n1=prev;
                            n2=current;
                        }
                    }
                    prev=current;
                    current=current->right;
                }
            }
        }
        int temp=n1->val;
        n1->val=n2->val;
        n2->val=temp;
    }
};