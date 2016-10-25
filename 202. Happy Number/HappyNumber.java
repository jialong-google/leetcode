public class Solution {
    public boolean isHappy(int n) {
        if(n == 1)
            return true;
        Set<Integer> hash = new HashSet<Integer>();
        while(n != 1)
        {
            int temp = n;
            int next = 0;
            while(temp != 0)
            {
                next += (temp % 10) * (temp % 10);
                temp /= 10;
            }
            if(next == 1)
                return true;
            if(hash.add(next) == false)
                return false;
            n = next;
        }
        return true;
    }
}