/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    private ArrayList<Integer> res;
    private int index;
    public NestedIterator(List<NestedInteger> nestedList) {
        res = new ArrayList<Integer>();
        gather(nestedList, res);
        index = 0;
    }
    private void gather(List<NestedInteger> nestedList, List<Integer> res)
    {
        if(nestedList == null)
            return ;
        for(int i = 0; i < nestedList.size(); i++)
        {
            if(nestedList.get(i).isInteger())
            {
                res.add(nestedList.get(i).getInteger());
            }
            else
            {
                gather(nestedList.get(i).getList(),res);
            }
        }
        return ;
    }

    @Override
    public Integer next() {
        if(index < res.size())
            return res.get(index++);
        return null;
    }

    @Override
    public boolean hasNext() {
        if(index < res.size())
            return true;
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */