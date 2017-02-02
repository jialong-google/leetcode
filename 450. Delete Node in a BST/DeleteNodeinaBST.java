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
    private TreeNode findNode(TreeNode root, int key)
    {
        if(root == null || root.val == key)
            return root;
        if(root.val < key)
            return findNode(root.right, key);
        return findNode(root.left, key);
    }
    private TreeNode helper(TreeNode root, int key)
    {
        if(root == null)
            return root;
        root.left = helper(root.left, key);
        root.right = helper(root.right, key);
        if(root.val == key)
        {
            if(root.left == null && root.right == null)
                return null;
            else if(root.left != null && root.right == null)
                return root.left;
            else if(root.left == null && root.right != null)
                return root.right;
            else // find a replacement;
            {
                TreeNode current = root.right;
                while(current.left != null)
                {
                    current = current.left;
                }
                root.val = current.val;
                root.right = helper(root.right, current.val);
                return root;
            }
        }
        else if(root.val < key)
        {
            helper(root.right, key);
            return root;
        }
        else
        {
            helper(root.left, key);
            return root;
            
        }
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode target = findNode(root, key);
        if(target == null )
            return root;
        return helper(root, key);
        //return root;
    }
}