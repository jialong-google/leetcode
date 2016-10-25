public class Solution {
    public String countAndSay(int n) {
        StringBuilder writer = new StringBuilder();
        writer.append('1');
        while(--n > 0)
        {
            String cur = writer.toString();
            writer = new StringBuilder();
            char prev =cur.charAt(0);
            int count = 1;
            for(int i = 1; i < cur.length(); i++)
            {
                if(cur.charAt(i) == prev)
                {
                    count ++;
                    continue;
                }
                writer.append(""+count + prev);
                prev = cur.charAt(i);
                count = 1;
            }
            writer.append(""+ count + prev);
        }
        return writer.toString();
    }
}