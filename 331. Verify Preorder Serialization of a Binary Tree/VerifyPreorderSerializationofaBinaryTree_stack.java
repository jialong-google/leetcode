public class Solution {
    public boolean isValidSerialization(String preorder) {
        if(preorder == null)
            return false;
    
        ArrayList<String> pars = new ArrayList<String>();
        int pre = 0;
        for(int i =1; i < preorder.length(); i++)
        {
            if(preorder.charAt(i) == ',')
            {
                pars.add(preorder.substring(pre,i));
                pre = i + 1;
            }
        }
        pars.add(preorder.substring(pre));
        
        Deque<String> stack = new LinkedList<String>();
        for(int i = 0; i < pars.size(); i++)
        {
            String cur = pars.get(i);
            if(cur.equals("#"))
            {
                while(!stack.isEmpty() && stack.peekLast().equals("#"))
                {
                    stack.pollLast();
                    if(stack.isEmpty())
                        return false;
                    else if(stack.peekLast().equals("#"))
                        return false;
                    stack.pollLast();
                }
                stack.offerLast("#");
            }
            else
            {
                stack.offerLast(cur);
            }
        }
        if(stack.size() == 1 && stack.peekLast().equals("#"))
            return true;
        return false;
    }
}