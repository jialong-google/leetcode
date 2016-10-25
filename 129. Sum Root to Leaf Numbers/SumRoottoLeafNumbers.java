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
    private int sum;
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        sum = 0;
        DFS(0,root);
        return sum;
    }
    public void DFS(int current, TreeNode root)
    {
        if(root.left == null && root.right == null)
        {
            sum = current * 10 + root.val + sum;
            return;
        }
        current = current * 10 + root.val;
        if(root.left != null)
            DFS(current, root.left);
        if(root.right != null)
            DFS(current, root.right);
    }
}