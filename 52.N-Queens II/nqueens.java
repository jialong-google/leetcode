public class Solution {
  public List<List<Integer>> nqueens(int n) {
    // Write your solution here.
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    boolean[] col = new boolean[n];
    boolean[] diag = new boolean[2 * n -1];
    boolean[] adiag = new boolean[2 * n -1];
    int[] arrange = new int[n];
    helper(n, 0, arrange, col, diag, adiag, res);
    return res;
  }
  public void helper(int n, int current, int[] arrange, boolean[] col, boolean[] diag, boolean[] adiag, List<List<Integer>> res)
  {
    if(current == n)
    {
      ArrayList<Integer> temp = new ArrayList<Integer>();
      for(int i = 0; i < n ; i++)
        temp.add(arrange[i]);
      res.add(temp);
    }
    for(int i =0 ; i < n ; i++)
    {
      if(valid(n, current, i, col,diag,adiag))
      {
        mark(n, current, i, col, diag, adiag);
        arrange[current] = i;
        helper(n, current +1, arrange, col, diag, adiag, res);
        unmark(n, current, i , col, diag, adiag);
      }
    }
  }
  public boolean valid(int n, int current, int position, boolean[] col, boolean[] diag, boolean[] adiag)
  {
    if(col[position]|| diag[current + position] || adiag[position - current + n - 1])
      return false;
    return true;
  }
  public void mark(int n, int current, int position, boolean[] col, boolean[] diag, boolean[] adiag)
  {
    col[position] = true;
    diag[current + position] = true;
    adiag[position - current + n -1] = true;
  }
  public void unmark(int n, int current, int position, boolean[] col, boolean[] diag, boolean[] adiag)
  {
    col[position] = false;
    diag[current + position] = false;
    adiag[position - current + n -1] = false;
  }
}
