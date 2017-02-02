public class Solution {
    public int hammingDistance(int x, int y) {
        int temp = x ^ y;
        int res = 0;
        for(int i = 0; i < 32; i++)
        {
            int k = 1 << i;
            if((temp & k) != 0)
                res ++;
        }
        return res;
    }
}