public class Solution {
    public boolean isValidSerialization(String preorder) {
        if(preorder == null)
            return false;
        int counter = 0;
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
        for(int i = 0; i < pars.size() - 1; i++)
        {
            if(pars.get(i).equals("#"))
            {
                counter --;
                if(counter < 0)
                    return false;
            }
            else
                counter ++;
        }
        if(!pars.get(pars.size() - 1).equals("#") || counter != 0)
            return false;
        return true;
    }
}