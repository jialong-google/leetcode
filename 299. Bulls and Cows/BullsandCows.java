public class Solution {
    public String getHint(String secret, String guess) {
        if(secret == null || secret.length() == 0)
            return "0A0B";
        int A = 0;
        int B = 0;
        Map<Character, Integer> hash = new HashMap<Character, Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        for(int i = 0; i < secret.length(); i++)
        {
            char current = secret.charAt(i);
            if(guess.charAt(i) == current)
            {
                A++;
                visited.add(i);
            }
            else
            {
                Integer temp = hash.get(current);
                if(temp == null)
                {
                    hash.put(current, 1);
                }
                else
                {
                    hash.put(current, temp + 1);
                }
            }
        }
        for(int i = 0; i < guess.length(); i++)
        {
            if(visited.contains(i))
            {
                continue;
            }
            Integer temp = hash.get(guess.charAt(i));
            if(temp == null || temp == 0)
            {
                continue;
            }
            else
            {
                B++;
                hash.put(guess.charAt(i), temp - 1);
            }
        }
        return A+"A"+B+"B";
    }
}