public class Solution {
    private class TrieNode
    {
        TrieNode[] next;
        int index;
        List<Integer> list;
        TrieNode()
        {
            next = new TrieNode[26];
            index = -1;
            list = new ArrayList<Integer>();
        }
    }
    private boolean validPalin(String word, int i, int j)
    {
        while(i < j)
        {
            if(word.charAt(i) == word.charAt(j))
            {
                i++;
                j--;
            }
            else
                return false;
        }
        return true;
    }

    private void addWord(String[] words, int index, TrieNode current)
    {
        String word = words[index];
        for(int i = word.length() - 1; i >= 0; i --)
        {
            int cur = word.charAt(i) - 'a';
            if(current.next[cur] == null)
            {
                current.next[cur] = new TrieNode();
            }
            if(validPalin(word, 0, i))
                current.list.add(index);
            current = current.next[cur];
        }
        current.index = index;
        current.list.add(index);
    }
    private void search(String[] words, int index, TrieNode current)
    {
        String word = words[index];
        for(int i = 0; i < word.length(); i++)
        {
            int cur = word.charAt(i) - 'a';
            if(current.index != -1 && current.index != index && validPalin(word, i, word.length() - 1))
            {
                res.add(Arrays.asList(index, current.index));
            }
            if(current.next[cur] == null)
                return;
            current = current.next[cur];
        }
        for(int i : current.list)
        {
            if(i == index)
                continue;
            res.add(Arrays.asList(index, i));
        }
    }
    private List<List<Integer>> res;
    public List<List<Integer>> palindromePairs(String[] words) {
        res = new ArrayList<List<Integer>>();
        if(words == null || words.length == 0)
            return res;
        TrieNode root = new TrieNode();
        for(int i = 0; i < words.length ; i++)
        {
            addWord(words, i, root);
        }
        for(int i = 0; i < words.length ;i++)
        {
            search(words, i, root);
        }
        return res;
    }
}