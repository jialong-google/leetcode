public class Solution {
    private String[][] element = new String[][] {{"0", "0"}, {"1", "1"}, {"8", "8"}, {"6", "9"}, {"9", "6"}};
    public int strobogrammaticInRange(String low, String high) {
        int count = 0;
        for(int i = low.length(); i <= high.length() ; i++)
        {
            count += helper(low, high, i, i).size();
        }
        return count;
    }
    private boolean valid(String low, String high, String cur)
    {
        //very important.
        if( cur.length() == low.length() && low.compareTo(cur) > 0 ||high.length() == cur.length() && high.compareTo(cur) < 0)
        {
            return false;
        }
        return true;
    }
    public List<String> helper(String low, String high, int n, int origin_n)
    {
        if(n == 0)
        {
            return Arrays.asList("");
        }
        List<String> res = new ArrayList<String>();
        if(n == 1)
        {
            for(int i = 0; i < 3; i ++)
            {
                if(valid(low, high, element[i][0]))
                {
                    res.add(element[i][0]);
                    //System.out.println(element[i][0]);
                }
            }
            return res;
        }
        List<String> prev = helper(low, high, n - 2, origin_n);
        for(int i = 0; i < prev.size(); i++)
        {
            for(int j = 0; j < element.length; j++)
            {
                if(n == origin_n && j == 0)
                    continue;
                String current = element[j][0] + prev.get(i) + element[j][1];
                if(valid(low, high, current))
                {
                    res.add(current);
                    //System.out.println(current);
                }
            }
        }
        return res;
    }
}