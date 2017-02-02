public class Solution {
    public String rearrangeString(String str, int k) {
        int[] valid = new int[26];
        int[] count = new int[26];
        if(str == null || str.length() == 0)
            return "";
        for(int i = 0; i < str.length(); i++)
        {
            count[str.charAt(i) - 'a'] ++;
        }
        
        StringBuilder sb = new StringBuilder(); 
        for(int i = 0; i < str.length(); i++)
        {
            int temp = greedyFind(valid, count, i) ; 
            if(temp == -1)
                return "";
            char next = (char)('a' + temp);
            sb.append(next);
            valid[temp] = i + k;
            count[temp] --;
        }
        return sb.toString();
        
    }
    public int greedyFind(int[] valid, int[] count, int current_index)
    {
        int res = -1;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < 26; i++)
        {
            if(count[i] > 0 && count[i] >= max && valid[i] <= current_index)
            {
                res = i;
                max = count[i];
            }
        }
        return res;
    }
}