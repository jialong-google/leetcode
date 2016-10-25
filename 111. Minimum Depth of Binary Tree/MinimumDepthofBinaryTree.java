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
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        int left = 0;
        int right = 0;
        int global = Integer.MAX_VALUE;
        if(root.left != null)
        {
            left = minDepth(root.left);
            global = Math.min(global, left);
        }
        if(root.right != null)
        {
            right = minDepth(root.right);
            global = Math.min(global, right);
        }
        return global + 1;
    }
}