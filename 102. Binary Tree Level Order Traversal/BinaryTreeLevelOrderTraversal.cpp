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
    vector<vector<int>> result;
    queue<TreeNode *> bfs1,bfs2;
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        if(root==NULL)
            return result;
        else
        {
            bfs1.push(root);
            while(1){
                vector<int> level;
                while(!bfs1.empty()){
                    TreeNode *p=bfs1.front();
                    level.push_back(p->val);
                    bfs1.pop();
                    if(p->left!=NULL)
                        bfs2.push(p->left);
                    if(p->right!=NULL)
                        bfs2.push(p->right);
                }
                result.push_back(level);
                if(bfs2.empty())
                    return result;
                else
                    swap(bfs2,bfs1);
            }
        }
    }
};