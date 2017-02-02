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
    private List<Integer> res = new ArrayList<Integer>();
    private void initial_pre(double target, TreeNode node, Deque<TreeNode> pre)
    {
        while(node != null)
        {
            if(node.val == target)
            {
                pre.offerLast(node);
                break;
            }
            else if(node.val < target)
            {
                pre.offerLast(node);
                node = node.right;
            }
            else
            {
                node = node.left;
            }
        }
    }
    private void initial_suc(double target, TreeNode node, Deque<TreeNode> suc)
    {
        while(node != null)
        {
            if(node.val == target)
            {
                suc.offerLast(node);
                break;
            }
            else if(node.val > target)
            {
                suc.offerLast(node);
                node = node.left;
            }
            else
            {
                node = node.right;
            }
        }
    }
    private TreeNode get_suc(Deque<TreeNode> suc)
    {
        TreeNode current = suc.pollLast();
        TreeNode node = current.right;
        while(node != null)
        {
            suc.offerLast(node);
            node = node.left;
        }
        return current;
    }
    private TreeNode get_pre(Deque<TreeNode> pre)
    {
        TreeNode current = pre.pollLast();
        TreeNode node = current.left;
        while(node != null)
        {
            pre.offerLast(node);
            node = node.right;
        }
        return current;
    }
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        if(root == null)
            return res;
        Deque<TreeNode> pre = new LinkedList<TreeNode>();
        Deque<TreeNode> suc = new LinkedList<TreeNode>();
        initial_pre(target, root, pre);
        initial_suc(target, root, suc);
        if(!pre.isEmpty() && !suc.isEmpty() && suc.peekLast().val == pre.peekLast().val)
        {
            get_suc(suc);
        }
        while(k-- > 0)
        {
            if(suc.isEmpty())
            {
                res.add(get_pre(pre).val);
            }
            else if(pre.isEmpty())
            {
                res.add(get_suc(suc).val);
            }
            else
            {
                double ss = Math.abs(suc.peekLast().val - target);
                double pp = Math.abs(pre.peekLast().val - target);
                if(ss < pp)
                {
                    res.add(get_suc(suc).val);
                }
                else
                {
                    res.add(get_pre(pre).val);
                }
            }
        }
        return res;
    }
}