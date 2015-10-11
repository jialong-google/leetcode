/**
 * Definition for binary tree with next pointer.
 * struct TreeLinkNode {
 *  int val;
 *  TreeLinkNode *left, *right, *next;
 *  TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
 * };
 */
class Solution {
public:
    void connect(TreeLinkNode *root) {
        if(root==NULL)
            return;
        if(root->left!= NULL && root->right!=NULL)
        {
            root->left->next=root->right;
            if(root->next!=NULL){
                if(root->next->left!=NULL)
                    root->right->next= root->next->left;
                else if(root->next->right!=NULL)
                    root->right->next= root->next->right;
                else// both children are empty.
                {
                    TreeLinkNode *p=root->next;
                    while(p!=NULL)
                    {
                        
                        if(p->left!=NULL)
                        {
                            root->right->next=p->left;
                            break;
                        }
                        else if(p->right!=NULL)
                        {
                            root->right->next=p->right;
                            break;
                        }
                        p=p->next;
                    }
                }
            }
        }
        else if(root->left != NULL && root->right == NULL)
        {
            if(root->next != NULL){
                if(root->next->left != NULL)
                    root->left->next = root->next->left;
                else if(root->next->right!=NULL)
                    root->left->next= root->next->right;
                else//both children are empty.
                {
                    TreeLinkNode *p=root->next;
                    while(p!=NULL)
                    {
                        
                        if(p->left!=NULL)
                        {
                            root->left->next=p->left;
                            break;
                        }
                        else if(p->right!=NULL)
                        {
                            root->left->next=p->right;
                            break;
                        }
                        p=p->next;
                    }
                }
            }
        }
        else if(root->left==NULL && root->right!=NULL)
        {
            if(root->next!=NULL){
                if(root->next->left!=NULL)
                    root->right->next= root->next->left;
                else if(root->next->right!=NULL)
                    root->right->next= root->next->right;
                else//both children are empty.
                {
                    TreeLinkNode *p=root->next;
                    while(p!=NULL)
                    {
                        if(p->left!=NULL)
                        {
                            root->right->next=p->left;
                            break;
                        }
                        else if(p->right!=NULL)
                        {
                            root->right->next=p->right;
                            break;
                        }
                        p=p->next;
                    }
                }
            }
        }
        connect(root->right);
        connect(root->left);
        
    }
};