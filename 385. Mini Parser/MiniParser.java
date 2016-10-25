/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {

    private int cur_num = 0;
    private boolean isNum = false;
    private boolean isNeg = false;
    public NestedInteger deserialize(String s) {
        if(s.charAt(0) != '[')
            return new NestedInteger(Integer.parseInt(s));
        Deque<NestedInteger> stack = new LinkedList<NestedInteger>();
        stack.add(new NestedInteger());
        NestedInteger cur = null;
        for(int i = 0; i < s.length(); i++)//[0,[[2,4,[3],[]]]]
        {
            char current = s.charAt(i);
            if('0'<= current && current <= '9')// is a number;
            {
                isNum = true;
                cur_num = current - '0' + 10 * cur_num;
            }
            else if(current == '[')
            {
                if(cur != null)
                    stack.offerLast(cur);
                cur = new NestedInteger();
            }
            else if(current == ']')// if num has ended.
            {
                if(isNum)
                {
                    cur.add(new NestedInteger(isNeg == true ? - cur_num: cur_num));
                    cur_num = 0;
                    isNum = false;
                    isNeg = false;
                }
                stack.peekLast().getList().add(cur);
                cur = stack.pollLast();
            }
            else if(current == '-')
            {
                cur_num = 0;
                isNeg = true;
                isNum = true;
            }
            else//current == ','
            {// for this case, no need to use the stack. Just add in the current list.
                if(isNum)
                {
                    cur.add(new NestedInteger(isNeg == true ? - cur_num : cur_num));
                    cur_num = 0;
                    isNum = false;
                    isNeg = false;
                }
                
            }
        }
        
        
        return cur.getList().get(0);
        
    }
}