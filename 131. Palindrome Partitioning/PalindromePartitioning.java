public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(s == null || s.length() <= 1)
        {
            List<String> current = new ArrayList<String>();
            current.add(s);
            result.add(current);
            return result;
        }
        boolean[][] isP = calculateMatrix(s);
        //System.out.println(isP[0][2]);
        List<String> current = new ArrayList<String>();
        helper(result, current, 0, s.length(), s,isP);
        return result;
    }
    public boolean[][] calculateMatrix(String s){
        int len = s.length();
        boolean[][] isP = new boolean[len][len];
        for(int i = len - 1; i >= 0; i--)
        {
            for(int j = i; j < len; j++)
            {
                if(s.charAt(i) == s.charAt(j))
                {
                    if(j - i < 2)
                        isP[i][j] = true;
                    else
                        isP[i][j] = isP[i + 1][j - 1];
                }
                else
                    isP[i][j] = false;
            }
        }
        return isP;
    }
    public void helper(List<List<String>> result, List<String> current, int index , int len , String s, boolean[][] isP)
    {
        if( index >= len)
        {
            List<String> memeda = new ArrayList<String>(current);
            result.add(memeda);
            return;
        }
        for(int i = index; i < len; i++)
        {
            if(isP[index][i] == true)
            {
                current.add(s.substring(index, i + 1));
                helper(result, current, i + 1, len, s,isP);
                current.remove(current.size() - 1);
            }
        }
        
    }
}
