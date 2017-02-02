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
    private int res = 0;
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
        hash.put(0, 1);
        helper(root, 0, sum, hash);
        return res;
    }
    private void helper(TreeNode root, int acc, int target, Map<Integer, Integer> hash)
    {
        if(root == null)
            return ;
        acc += root.val;
        Integer temp = hash.get(acc - target);
        if(temp != null)
        {
            res += temp;
        }
        Integer temp2 = hash.get(acc);
        if(temp2 == null)
        {
            hash.put(acc, 1);
        }
        else
        {
            hash.put(acc, temp2 + 1);
        }
        helper(root.left, acc , target, hash);
        helper(root.right, acc, target, hash);
        hash.put(acc, hash.get(acc) - 1);
    }
}