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
    public boolean hasPathSum(TreeNode root, int sum) {
        
        return helper(root, sum, 0);
    }
    public boolean helper(TreeNode root, int sum ,int current)
    {
        if(root == null)
            return false;
        if(sum == current + root.val && root.left == null && root.right == null)
            return true;
        if(helper(root.left, sum, current + root.val) || helper(root.right, sum ,current + root.val))
            return true;
        return false;
    }
}