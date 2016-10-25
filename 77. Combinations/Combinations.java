public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();
        helper(res, n, k, current, 1);
        return res;
    }
    public void helper(List<List<Integer>> result, int n, int k, List<Integer> current, int index)
    {
        if(current.size() == k)
        {
            List<Integer> xinde = new ArrayList<Integer>(current);
            result.add(xinde);
            return;
        }
        for(int i = index; i <= n; i++)
        {
            current.add(i);
            helper(result, n, k, current, i + 1);
            current.remove(current.size() - 1);
        }
    }
}