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
    private static class rangeNode{
        int begin;
        int end;
        int num;
        rangeNode(){
            begin = Integer.MAX_VALUE;
            end = Integer.MIN_VALUE;
            num = -1;
        }
    }
    private int res = 0;
    public rangeNode helper(TreeNode root)
    {
        rangeNode record = new rangeNode();
        if(root == null)
        {
            return record;
        }
        rangeNode left = helper(root.left);
        rangeNode right = helper(root.right);
        if(left.num == -1 && right.num == -1)
        {
            record.num = 1;
            record.begin = root.val;
            record.end = root.val;
            res = Math.max(1, res);
            return record;
        }
        if(left.num != 0 && root.val > left.end && right.num != 0 && root.val < right.begin)
        {
            record.num = 1 + (left.num == -1? 0:left.num)+ (right.num == -1? 0:right.num);
            record.begin = Math.min(left.begin, root.val);
            record.end = Math.max(right.end, root.val);
            res = Math.max(record.num, res);
            return record;
        }
        record.num = 0;
        return record;
    }
    public int largestBSTSubtree(TreeNode root)
    {
        helper(root);
        return res;
    }
}