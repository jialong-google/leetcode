public class Solution {
    public List<String> readBinaryWatch(int num) {
        if(num < 0 || num > 10)
            return new ArrayList<String>();
        List<String> res = new ArrayList<String>();
        StringBuilder writer = new StringBuilder();
        for(int i = 0; i < 12; i ++)
        {
            for(int j = 0; j < 60; j++)
            {
                writer = new StringBuilder();
                if(count(i) + count(j) == num)
                {
                    //add it.
                    writer.append(i + ":" + (j < 10? "0" + j : j));
                    res.add(writer.toString());
                }
            }
        }
        return res;
    }
    //count out how many 1 a num could have. 
    public int count(int num)
    {
        int counter = 0;
        while(num != 0)
        {
            counter ++;
            num = num & (num - 1);
        }
        return counter;
    }
}