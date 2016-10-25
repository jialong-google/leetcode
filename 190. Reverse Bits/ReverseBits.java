public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        n = ((n & 0x55555555) <<1) | ((n >>> 1) & 0x55555555);
        n = ((n & 0x33333333) <<2) | ((n >>> 2) & 0x33333333);
        n = ((n & 0x0f0f0f0f) <<4) | ((n >>> 4) & 0x0f0f0f0f);
        return (n << 24) |((n & 0x0000ff00)<<8) |((n & 0x00ff0000)>>> 8)|( n>>> 24);
    }
}