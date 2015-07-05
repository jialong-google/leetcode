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
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> postorder;
        stack<TreeNode *> stk;
        if(root!= NULL)
            stk.push(root);
        TreeNode * current;
        while(!stk.empty()){
            current=stk.top();
            if(current->right==NULL && current->left==NULL){
                postorder.push_back(current->val);
                stk.pop();
            }
            if(current->right!=NULL){
                stk.push(current->right);
                current->right=NULL;
            }
            if(current->left!=NULL){
                stk.push(current->left);
                current->left=NULL;
            }
        }
        return postorder;
    }
};
