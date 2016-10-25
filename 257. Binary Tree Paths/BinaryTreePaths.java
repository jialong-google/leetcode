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
    private List<String> res;
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<String>();
        if(root == null)
            return res;
        helper(root, "");
        return res;
    }
    public void helper(TreeNode root, String writer)
    {
        if(root.left == null && root.right == null)
        {
            res.add(writer + root.val);
            return ;
        }
        writer += root.val + "->"; 
        if(root.left != null)
            helper(root.left, writer);
        if(root.right != null)
            helper(root.right,writer);
    }
}