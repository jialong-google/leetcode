public class Solution {
    private class Node
    {
        int val;
        int sum;
        int dup;
        Node right;
        Node left;
        Node(int val)
        {
            this.val = val;
            dup = 1;
        }
    }
    private Node root = null;
    private Integer[] res;
    private Node helper(int[] nums, int i, int presum, Node current)
    {
        if(current == null)
        {
            current = new Node(nums[i]);
            res[i] = presum;
        }
        else if(current.val == nums[i])
        {
            current.dup ++;
            res[i] = current.sum + presum;
        }
        else if(current.val < nums[i])
        {
            current.right = helper(nums, i, presum + current.sum + current.dup, current.right);
        }
        else
        {
            current.sum++;
            current.left = helper(nums, i, presum, current.left);
        }
        return current;
    }
    
    public List<Integer> countSmaller(int[] nums) {
        if(nums == null || nums.length == 0)
            return new ArrayList<Integer>();
        res = new Integer[nums.length];
        for(int i = nums.length - 1; i >= 0; i--)
        {
            root = helper(nums, i, 0, root);
        }
        return Arrays.asList(res);
    }
}