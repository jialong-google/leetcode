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
    private int best;
    public int closestValue(TreeNode root, double target) {
        if(root == null)
        {
            return 0;
        }
        best = root.val;
        return helper(root, target);
    }
    public int helper(TreeNode root, double target){
        if(root == null)
        {
            return best;
        }
        if(Math.abs(best - target) > Math.abs(root.val - target))
        {
            best = root.val;
        }
        if(target == (double) root.val)
        {
            return root.val;
        }
        else if(target > (double)root.val)
        {
            root = root.right;
        }
        else
        {
            root = root.left;
        }
        return helper(root, target);

    }
}