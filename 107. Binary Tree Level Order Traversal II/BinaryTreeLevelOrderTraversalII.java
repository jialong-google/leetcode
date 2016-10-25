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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null)
            return res;
        queue.offer(root);
        while(!queue.isEmpty())
        {
            List<Integer> cur = new ArrayList<Integer>();
            int s = queue.size();
            for(int i = 0; i < s; i++)
            {
                TreeNode top = queue.poll();
                cur.add(top.val);
                if(top.left != null)
                {
                    queue.offer(top.left);
                }
                if(top.right != null)
                {
                    queue.offer(top.right);
                }
            }
            res.add(cur);
        }
        for(int i = 0 ; i < res.size() / 2; i++)
        {
            List<Integer> temp = res.get(i);
            res.set(i, res.get(res.size() - 1 - i));
            res.set(res.size() - 1 - i, temp);
        }
        return res;
    }
}