public class Solution {
    public int countPrimes(int n) {
        if(n <=2) 
            return 0;
        boolean[] table = new boolean[n];
        
        int counter = 0;
        for(int i = 2; i < n; i++)
        {
            if(table[i] == false)
            {
                counter ++;
                for(long j =(long) i * i; j < n; j += i)
                {
                    table[(int)j] = true;
                }
            }
        }
        return counter;
    }
}