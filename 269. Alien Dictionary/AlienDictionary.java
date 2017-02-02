public class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();
        Map<Character, Integer> inDegrees = new HashMap<Character, Integer>();
        if(words == null || words.length == 0)
            return "";
        for(int i = 0; i < words.length; i++)
        {
            for(int j = 0; j < words[i].length(); j++)
            {
                inDegrees.put(words[i].charAt(j), 0);
            }
        }
        
        for(int i = 1; i < words.length ;i ++)
        {
            String w1 = words[i - 1];
            String w2 = words[i];
            int len = Math.min(w1.length(), w2.length());
            int j = 0;
            for(; j < len; j++)
            {
                char cur1 = w1.charAt(j);
                char cur2 = w2.charAt(j);
                if(cur1 != cur2)
                {
                    Set<Character> temp = map.get(cur1);
                    if(temp == null)
                    {
                        temp = new HashSet<Character>();
                    }
                    if(temp.add(cur2))
                    {
                        map.put(cur1, temp);
                        Integer temp2 = inDegrees.get(cur2);
                        if(temp2 == null)
                        {
                            temp2 = 0;
                        }
                        temp2 += 1;
                        inDegrees.put(cur2, temp2);
                    }
                    break;
                }
            }
            if(j == len && len== w2.length() && w1.length() > w2.length())
                return "";
        }
        
        Queue<Character> queue = new LinkedList<Character>();
        for(Map.Entry<Character,Integer> item: inDegrees.entrySet())
        {
            if(item.getValue() == 0)
            {
                queue.offer(item.getKey());
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty())
        {
            char current = queue.poll();
            sb.append(current);
            Set<Character> next = map.get(current);
            if(next == null)
                continue;
            for(Character i : next)
            {
                Integer temp = inDegrees.get(i);
                if(temp == null)
                {
                    continue;
                }
                inDegrees.put(i,temp - 1);
                if(temp == 1)
                {
                    queue.offer(i);
                }
            }
        }
        if(inDegrees.size() == sb.length())
            return sb.toString();
        return "";
        
    }
}