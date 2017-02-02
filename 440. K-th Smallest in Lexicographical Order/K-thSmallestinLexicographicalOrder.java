public class Solution {
    public int findKthNumber(int n, int k) {
        int current = 1;
        k--;
        while(k > 0)
        {
            int steps = calcSteps(n, current, current + 1);
            if(k >= steps)
            {
                k -= steps;
                current = current + 1;
            }
            else
            {
                k--;
                current = current * 10;
            }
        }
        return current;
    }
    private int calcSteps(int n , long n1, long n2)
    {
        int steps = 0;
        while(n1 <= n)
        {
            steps += Math.min(n + 1, n2) - n1;
            n1 *= 10;
            n2 *= 10;
        }
        return steps;
    }
}