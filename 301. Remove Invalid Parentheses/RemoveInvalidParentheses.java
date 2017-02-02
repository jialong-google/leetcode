public class Solution {
    private List<String> res;
    public List<String> removeInvalidParentheses(String s) {
        res = new ArrayList<String>();
        if(s == null || s.length() == 0)
        {
            res.add("");
            return res;
        }
        helper(s, 0, 0, new char[]{'(', ')'});
        return res;
    }
    private void helper(String s, int last_i, int last_j, char[] par)
    {
        int stack = 0;
        for(int i = last_i; i < s.length(); i++)
        {
            char cur = s.charAt(i);
            if(cur == par[0])
            {
                stack++;
            }
            if(cur == par[1])
            {
                stack--;
            }
            if(stack >= 0)
                continue;
            for(int j = last_j; j <= i; j++)
            {
                if(s.charAt(j) == par[1] &&( j == last_j || s.charAt(j - 1) != par[1]))
                    helper(s.substring(0, j) + s.substring(j + 1), i, j,par);
            }
            return ;
        }
        s = new StringBuilder(s).reverse().toString();
        if(par[0] == '(')
        {
            helper(s, 0, 0, new char[]{')','('});
        }
        else
        {
            res.add(s);
        }
    }
}