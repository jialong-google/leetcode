public class Solution {
    ArrayList<List<Integer>> res;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<List<Integer>>();
        int next = Math.min(n,9);
        ArrayList<Integer> cur = new ArrayList<Integer>();
        DFS(k, n, next, cur);
        return res;
    }
    public void DFS(int k, int remain, int next_candidate, List<Integer> cur)
    {
        if(remain == 0 && k == 0)
        {
            res.add(new ArrayList<Integer>(cur));//!!!!!!!!remember to store a copy instead of an address!
            return;
        }
        for(int i = next_candidate; i >= 1; i--)
        {
            if(remain >= i)
            {
                cur.add(i);
                next_candidate = Math.min(i - 1, remain);
                DFS(k - 1, remain - i, next_candidate, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }
}