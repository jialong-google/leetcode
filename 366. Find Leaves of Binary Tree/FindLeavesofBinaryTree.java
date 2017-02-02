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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        while(root != null)
        {
            List<Integer> temp = new ArrayList<Integer>();
            root = change(root, temp);
            res.add(temp);
        }
        return res;
    }
    private TreeNode change(TreeNode root, List<Integer> temp)
    {
        if(root == null)
        {
            return root;
        }
        else if(root.left == null && root.right == null)
        {
            temp.add(root.val);
            return null;
        }
        else
        {
            root.left = change(root.left, temp);
            root.right = change(root.right, temp);
            return root;
        }
    }
}