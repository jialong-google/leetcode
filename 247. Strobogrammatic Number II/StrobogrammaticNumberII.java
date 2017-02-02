public class Solution {
    //char[][] element = new char[][]{ {0, 0}, {1, 1}, {8, 8}, {6, 9}, {9, 6}};
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }
    private List<String> helper(int n, int origin_n)
    {
        if(n == 0)
        {
            return Arrays.asList("");
        }
        if(n == 1)
        {
            return Arrays.asList("0", "1", "8");
        }
        List<String> current = helper(n - 2, origin_n);
        List<String> res = new ArrayList<String>();
        for(int i = 0; i < current.size(); i++)
        {
            String cur = current.get(i);
            if(n != origin_n)
            {
                res.add("0" + cur + "0");
            }
            res.add("1" + cur + "1");
            res.add("8" + cur + "8");
            res.add("6" + cur + "9");
            res.add("9" + cur + "6");
        }
        return res;
    }
}