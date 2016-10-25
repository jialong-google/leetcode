public class Solution {
    public int lastRemaining(int n) {
        if(n <= 0)
            return 0;
        if(n == 1)
            return 1;
        int[] remain = new int[n];
        for(int i = 0; i < n; i ++)
        {
            remain[i] = i + 1;
        }
        while(n > 1)
        {
            for(int i = 0; i < remain.length && n > 1; i++)
            {
                if(remain[i] != -1)
                {
                    remain[i] = -1;
                    while(i < remain.length && remain[i] == -1) i++;
                    n--;
                }
            }
            for(int i = remain.length - 1; i >= 0 && n > 1; i--)
            {
                if(remain[i] != -1)
                {
                    remain[i] = -1;
                    while(i >= 0 && remain[i] == -1) i--;
                    n--;
                }
            }
        }
        for(int i = 0 ; i < remain.length; i++)
        {
            if(remain[i] != -1)
                return remain[i];
        }
        return 0;
        
    }
}