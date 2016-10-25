public class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        long k = 1;//long!!!
        while(n >= k)
        {
            k *= 5;
            res += n/k;
        }
        return res;
    }
}