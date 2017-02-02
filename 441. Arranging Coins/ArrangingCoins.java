public class Solution {
    public int arrangeCoins(int n) {
        //n^2 + n - 2 * sum <= 0
        return (int)((-1.0 + Math.sqrt(1 +8*(long)n))/2);
    }
}