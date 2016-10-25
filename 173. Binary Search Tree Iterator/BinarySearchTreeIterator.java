/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    private Deque<TreeNode> stack;
    private TreeNode tr;
    public BSTIterator(TreeNode root) {
        stack = new LinkedList<TreeNode>();
        tr = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return ((tr != null) || !stack.isEmpty());
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode res = null;
        while(tr != null)
        {
            stack.offerLast(tr);
            tr = tr.left;
        }
        tr = stack.peekLast().right;
        res = stack.pollLast();
        return res.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */