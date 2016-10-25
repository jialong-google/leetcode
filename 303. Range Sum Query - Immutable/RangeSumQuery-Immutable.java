public class NumArray {
    int[] add;
    public NumArray(int[] nums) {
        add = new int[nums.length + 1];
        int roll = 0;
        add[0] = 0;
        for(int i = 1; i < add.length; i++)
        {
            roll += nums[i - 1];
            add[i] = roll;
        }
    }

    public int sumRange(int i, int j) {
        return add[j + 1] - add[i];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);