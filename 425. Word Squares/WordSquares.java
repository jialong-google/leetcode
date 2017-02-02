public class Solution {
    class Node{
        Node[] children;
        String val;
        Node()
        {
            children = new Node[26];
            val = null;
        }
    }
    private Node root = null;
    private List<List<String>> res = new ArrayList<List<String>>();
    public void addTrie(String name, Node root)
    {
        if(root == null)
        {
            return ;
        }
        Node current = root;
        for(int i = 0; i < name.length(); i++)
        {
            int cur = name.charAt(i) - 'a';
            if(current.children[cur] == null)
            {
                current.children[cur] = new Node();
            }
            current = current.children[cur];
        }
        current.val = name;
    }
    public void helper(int row, int col, Node[] rows, int len)
    {
        if((row == col) && (col == len))
        {
            List<String> temp = new ArrayList<String>();
            for (int i=0; i<len; i++) {
                temp.add(new String(rows[i].val) );
            }
            res.add(temp);
            return;
        }
        if(col < len)
        {
            Node curRow = rows[row];
            Node curCol = rows[col];
            for(int i = 0; i < 26; i++)
            {
                if(curRow.children[i] != null && curCol.children[i] != null)
                {
                    rows[row] = curRow.children[i];
                    rows[col] = curCol.children[i];
                    helper(row, col + 1, rows, len);
                }
            }
            rows[row] = curRow;
            rows[col] = curCol;
        }
        else
        {
            helper(row + 1, row + 1, rows, len);
        }
        
    }
    public List<List<String>> wordSquares(String[] words) {
        if(words == null || words.length == 0)
            return res;
        root = new Node();
        int len = words[0].length();
        for(String w : words)
        {
            addTrie(w, root);
        }
        Node[] rows = new Node[len];
        for(int i = 0; i < len; i++)
        {
            rows[i] = root;
        }
        helper(0, 0, rows, len);
        return res;
    }
}