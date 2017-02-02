public class Solution {
    private List<String> res = new ArrayList<String>();
    public List<String> generatePalindromes(String s) {
        if(s == null || s.length() == 0)
            return res;
        int odd_number_count = 0;
        int[] record_of_char = new int[256];
        for(int i = 0; i < s.length(); i++)
        {
            int current = (int)s.charAt(i);
            if(record_of_char[current] % 2 == 0)
                odd_number_count ++;
            else
                odd_number_count --;
            record_of_char[current] ++;
        }
        if(odd_number_count > 1)
            return res;
        StringBuilder sb = new StringBuilder();
        Character odd = null;
        for(int i = 0; i < 256; i++)
        {
            if(record_of_char[i] % 2 == 1)
            {
                record_of_char[i]--;
                odd = (char)i;
            }
            while(record_of_char[i] != 0)
            {
                sb.append((char) i);
                record_of_char[i] -= 2;
            }
        }
        helper(sb.toString(), 0);
        
        for(int i = 0; i < res.size(); i++)
        {
            StringBuilder temp_current = new StringBuilder(res.get(i));
            String current = null;
            if(odd != null)
                current = temp_current.toString() + odd + temp_current.reverse().toString();
            else
                current = temp_current.toString() + temp_current.reverse().toString();
            res.set(i, current);
        }
        return res;
    }
    private void helper(String material, int depth)
    {
        if(depth == material.length())
        {
            res.add(material);
            return;
        }
        Set<Character> set = new HashSet<Character>();
        char[] array = material.toCharArray();
        for(int i = depth; i < material.length(); i++)
        {
            if(set.add(material.charAt(i)))
            {
                char temp = array[depth];
                array[depth] = array[i];
                array[i] = temp;
                helper(new String(array), depth + 1);
                temp = array[depth];
                array[depth] = array[i];
                array[i] = temp;
            }
        }
    }
}