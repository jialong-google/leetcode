public class Solution {
    private long[] sum;
    private int mergeSort(int lower, int upper, int i, int j){
        if(i > j)
            return 0;
        if(i == j )
        {
            if(sum[i] <= upper && sum[i] >= lower)
                return 1;
            return 0;
        }
        long[] temp = new long[j - i + 1];
        int mid = i +(j - i) / 2;
        int counter = mergeSort(lower, upper, i, mid) + mergeSort(lower, upper, mid + 1, j);
        int low = mid + 1;
        int up = mid + 1;
        for(int pivot = i; pivot <= mid; pivot ++)
        {
            while(low <= j && sum[low] - sum[pivot] < lower)
                low ++;
            while(up <= j && sum[up] - sum[pivot] <= upper)
                up ++;
            counter += up - low;
        }
        // lets merge together.
        int p1 = i;
        int p2 = mid + 1;
        for(int k = i; k <= j; k++)
        {
            if(p1 <= mid && (p2 > j || sum[p1] < sum[p2]) )
            {
                temp[k - i] = sum[p1 ++];
            }
            else
            {
                temp[k - i] = sum[p2 ++];
            }
        }
        for(int k = i; k <= j; k++)
        {
            sum[k] = temp[k - i];
        }
        return counter;
    }
    
    public int countRangeSum(int[] nums, int lower, int upper) {
        if(nums == null || nums.length == 0)
            return 0;
        sum = new long[nums.length + 1];
        for(int i = 1; i < sum.length; i++)
        {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        return mergeSort(lower, upper, 1, nums.length);
    }
}