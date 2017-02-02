public class Solution {
    public boolean isStrobogrammatic(String num) {
        int[] hash = {0, 1, -1, -1, -1, -1, 9, -1, 8, 6};
        if(num == null || num.length() == 0)
        {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = num.length() - 1; i >= 0; i--)
        {
            int current = num.charAt(i) - '0';
            if(current <= 9 && current >= 0 && hash[current] != -1)
            {
                sb.append(hash[current]);
            }
            else
            {
                return false;
            }
        }
        if(sb.toString().equals(num))
        {
            return true;
        }
        return false;
    }
}