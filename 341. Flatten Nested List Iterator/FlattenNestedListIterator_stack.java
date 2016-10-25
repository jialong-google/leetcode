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
    private Deque<NestedInteger> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new LinkedList<NestedInteger>();
        for(int i = nestedList.size() - 1; i >= 0; i--)
        {
            stack.offerLast(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        if(stack.isEmpty() == true)
            return null;
        //while(!stack.isEmpty())
        else{
            NestedInteger cur = stack.pollLast();
            if(cur.isInteger())
                return cur.getInteger();
            else
            {
                List<NestedInteger> current = cur.getList();
                for(int i = current.size() - 1; i >= 0; i--)
                {
                    stack.offerLast(current.get(i));
                }
                return next();
            }
        }
        //return null;
    }

    @Override
    public boolean hasNext() {
        if(stack.isEmpty() == true)
        {
            return false;
        }
        //while(!stack.isEmpty())
        else{
            NestedInteger cur = stack.peekLast();
            if(cur.isInteger())
                return true;
            else
            {
                List<NestedInteger> current = stack.pollLast().getList();
                for(int i = current.size() - 1; i >= 0; i--)
                {
                    stack.offerLast(current.get(i));
                }
                return hasNext();
            }
        }
        //return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */