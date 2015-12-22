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
    int maxPathSum(TreeNode* root) {
        int m=-999;
        DFS(root,m);
        return m;
    }
    
    int DFS(TreeNode* n, int &m){//return the max path;
        int path=n->val;
        m= max(path,m);
        //left max;
        int l=0;
        if(n->left!=NULL)
            l=max(DFS(n->left,m),0);
        //right max;
        int r=0;
        if(n->right!=NULL)
            r=max(DFS(n->right,m),0);
        //left center right max;
        int two= l+r+n->val;
        m=max(two, m);
        path=n->val+max(l,r);
        m=max(path,m);
        return path;
    }
};