/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null)
            return "";
        queue.offer(root);
        while(!queue.isEmpty())
        {
            TreeNode temp = queue.poll();
            if(temp == null)
            {
                sb.append("null ");
                continue;
            }
            else
            {
                sb.append(temp.val + " ");
            }
            queue.offer(temp.left);
            queue.offer(temp.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0)
            return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        String[] parse = data.split(" ");
        TreeNode root = new TreeNode(Integer.valueOf(parse[0]));
        TreeNode current = root;
        queue.offer(current);
        for(int i = 1; i < parse.length; i+= 2)
        {
            current = queue.poll();
            if(!parse[i].equals("null"))
            {
                current.left = new TreeNode(Integer.valueOf(parse[i]));
                queue.offer(current.left);
            }
            if(!parse[i + 1].equals("null"))
            {
                current.right = new TreeNode(Integer.valueOf(parse[i + 1]));
                queue.offer(current.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));