public class Solution {
    public List<Integer> lexicalOrder(int n) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(n <= 0)
            return res;
        int temp = 1;
        for(int i = 1; i <= n; i++)
        {
            res.add(temp);
            if(temp * 10 <= n)
            {
                temp *= 10;
            }
            else if(temp % 10 != 9 && temp + 1 <= n)
            {
                temp = temp + 1;
            }
            else if(temp % 10 != 9 )
            {
                temp = temp / 10 + 1;
                while(temp % 10 == 0)
                {
                    temp = temp / 10;
                }
            }
            else// the last one is 9
            {
                temp ++;
                while(temp % 10 == 0)
                {
                    temp = temp / 10;
                }
            }
        }
        return res;
    }
}