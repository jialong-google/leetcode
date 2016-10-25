/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        return helper(root);        
    }
    public int helper(TreeNode root)
    {
        if(root == null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        return Math.max(left, right) + 1;
    }
}