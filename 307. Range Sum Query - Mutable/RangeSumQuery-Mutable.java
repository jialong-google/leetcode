public class NumArray {
    private int[] r = null;
    private int[] tree = null;
    public NumArray(int[] nums) {
        r = new int[nums.length];
        tree = new int[r.length + 1];
        for(int i = 0; i < nums.length; i++)
        {
            add(i + 1, nums[i]);
        }
    }
    void add(int i, int val)
    {
        r[i - 1] = val;
        for(; i <= r.length; i+= i & - i)
        {
            tree[i] += val;
        }
    }
    void update(int i, int val) 
    {
        int add = val - r[i];
        add(i + 1, add);
        r[i] = val;
    }
    private int sum(int i)
    {
        int res = 0;
        for(; i > 0; i -= i & - i)
        {
            res += tree[i];
        }
        return res;
    }
    public int sumRange(int i, int j) {
        return sum(j + 1) - sum(i);
    }
}