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
    public boolean isBalanced(TreeNode root) {
        if(helper(root) == -1)
            return false;
        return true;
    }
    public int helper(TreeNode root){
        if(root == null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if(left == -1 || right == -1)
            return -1;
        if(left - right > 1 || right - left > 1)
            return -1;
        return Math.max(left, right) + 1;
    }
}