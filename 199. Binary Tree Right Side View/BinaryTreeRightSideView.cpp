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
    vector<int> result;
    queue<TreeNode *> bfs1,bfs2;
public:
    vector<int> rightSideView(TreeNode* root) {
        if(root!=NULL)
            bfs1.push(root);
        else
            return result;
        TreeNode* p;
        while(1){
            while(!bfs1.empty()){
                p=bfs1.front();
                if(p->left!=NULL)
                    bfs2.push(p->left);
                if(p->right!=NULL)
                    bfs2.push(p->right);
                bfs1.pop();
            }
            result.push_back(p->val);
            if(!bfs2.empty())
                swap(bfs1,bfs2);
            else
                return result;
        }
    }
};