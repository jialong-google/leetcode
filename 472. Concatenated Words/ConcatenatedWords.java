public class Solution {
    private class TrieNode
    {
        TrieNode[] children;
        //String word;
        boolean isEnd;
        TrieNode()
        {
            children = new TrieNode[26];
            isEnd = false;
        }
        void addWord(String s)
        {
            TrieNode node = root;
            for(int i = 0; i < s.length(); i++)
            {
                int bias = s.charAt(i) - 'a';
                if(node.children[bias] == null)
                {
                    node.children[bias] = new TrieNode();
                }
                node = node.children[bias];
            }
            //node.word = s;
            node.isEnd = true;
        }
    }
    List<String> res = new ArrayList<String>();
    TrieNode root = null;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        if(words == null || words.length == 0)
            return res;
        Arrays.sort(words, new Comparator<String>()
        {
            @Override
            public int compare(String s1, String s2)
            {
                int len1 = s1.length();
                int len2 = s2.length();
                if(len1 == len2)
                    return 0;
                return len1 < len2? -1: 1;
            }
        });
        root = new TrieNode();
        root.addWord(words[0]);
        for(int i = 1; i < words.length; i++)
        {
            //if(words[i].equals(words[i - 1]))
            //    continue;
            if(search(words[i]))
            {
                res.add(words[i]);
            }
            root.addWord(words[i]);
        }
        
        return res;
    }
    private boolean search(String s)
    {
        if(s.length() == 0)
            return true;
        TrieNode node = root;
        for(int i = 0; i < s.length(); i++)
        {
            int bias = s.charAt(i) - 'a';
            if(node.children[bias] == null)
                return false;
            else
            {
                node = node.children[bias];
                if(node.isEnd && search(s.substring(i + 1)))
                {
                    return true;
                }
            }
        }
        return false;
    }
}