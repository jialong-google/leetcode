public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int counter = 1;
        for(int i = 1; i <= n; i++)
        {
            counter += getter(i);
        }
        return counter;
    }
    public int getter(int k)
    {
        //if(k == 1)
        //    return 10;
        int counter = 9;
        for(int i = 11 - k; i <= 9; i++)
        {
            counter *= i;
        }
        return counter;
    }
}