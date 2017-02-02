public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        if(s == null || s.length() == 0)
            return new ArrayList<String>();
        List<String> res = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length() - 1; i++)
        {
            if(s.charAt(i) == '+' && s.charAt(i + 1) == '+')
            {
                sb.setLength(0);
                sb.append(s.substring(0, i));
                sb.append("--");
                sb.append(s.substring(i + 2));
                res.add(sb.toString());
            }
        }
        return res;
    }
}