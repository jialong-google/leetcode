public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(numRows == 0)
            return res;
        res.add(new ArrayList<Integer>(){{add(1);}});
        int row = 1;
        while(row < numRows)
        {
            List<Integer> cur = res.get(row - 1);
            ArrayList<Integer> n = new ArrayList<Integer>();
            for(int i = -1; i < cur.size(); i++)
            {
                if(i == -1 || i == cur.size() - 1)
                {
                    n.add(1);
                }
                else
                {
                    n.add(cur.get(i) + cur.get(i + 1));
                }
            }
            res.add(n);
            row ++;
        }
        return res;
    }
}