public class Solution {
    
    private String calculateHash(String str)
    {
        StringBuilder sb = new StringBuilder();
        if(str.length() == 0)
            return "";
        int temp = str.charAt(0) - 'a';
        for(int i = 0; i < str.length(); i++)
        {
            sb.append((str.charAt(i) - 'a' + 26 - temp)%26 + 'a');
        }
        //System.out.println(sb.toString());
        return sb.toString();
    }
    
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(strings == null || strings.length == 0)
        {
            return res;
        }
        Map<String, List<String>> hash = new HashMap<String, List<String>>();
        for(int i = 0; i < strings.length; i++)
        {
            String current = calculateHash(strings[i]);
            List<String> clist = hash.get(current);
            if(clist == null)
            {
                clist = new ArrayList<String>();
            }
            clist.add(strings[i]);
            hash.put(current, clist);
        }
        for(List<String> cur: hash.values())
        {
            res.add(cur);
        }
        return res;
    }
}