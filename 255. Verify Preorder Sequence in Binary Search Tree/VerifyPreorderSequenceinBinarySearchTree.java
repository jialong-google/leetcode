public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        int top = 0;
        for(int i = 0 ; i < preorder.length; i++)
        {
            if(preorder[i] < low)
            {
                return false;
            }
            while(top != 0 && preorder[top - 1] < preorder[i])
            {
                low = preorder[--top];
            }
            preorder[top ++ ] = preorder[i]; 
        }
        return true;
    }
}