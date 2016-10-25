public class Solution {
    public int lastRemaining(int n) {
        if(n <= 0)
            return 0;
        int intervel = 1;
        int head = 1;
        while( n != 1)
        {
            //left to right;
            head += intervel;
            n = n /2;
            if(n == 1)
                return head;
            intervel *= 2;
            //right to left;
            if(n % 2 == 1)
            {
                head += intervel;
            }
            intervel *= 2;
            n = n /2;
        }
        return head;
        
    }
}