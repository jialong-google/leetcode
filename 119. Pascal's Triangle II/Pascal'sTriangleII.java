public class Solution {
    //0:  1 
    //1:  1 1 
    //2:  1 2 1 
    //3:  1 3 3 1
    //4:  1 4 6 4 1 
    //5:  1 5 10 10 5 1
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>(rowIndex + 1);
        res.add(1);
        for(int i = 1; i < rowIndex + 1; i++)
        {
            int pre = 1;
            for(int j = 1; j < i + 1; j++)
            {
                if(j == i )
                    res.add(1);
                else
                {
                    int temp = res.get(j);
                    res.set(j, pre + res.get(j));
                    pre = temp;
                }
            }
        }
        return res;
        
    }
}