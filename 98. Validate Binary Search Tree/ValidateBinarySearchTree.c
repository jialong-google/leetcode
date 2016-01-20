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
    int i=-999;
public:
    bool isValidBST(TreeNode* root) {
        bool b=true;
        BSThelper(root,b);
        return b;
    }
    void BSThelper(TreeNode* r, bool &b)
    {
        if(r!=NULL)
        {
            if(r->left!=NULL)
                BSThelper(r->left,b);
            if(i!=-999 && i>=r->val)
            {
                b=false;
                return;
            }
            else
                i=r->val;
            if(r->right!=NULL)
                BSThelper(r->right,b);
        }
    }
};