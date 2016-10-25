public class Solution {
    
    public List<Integer> diffWaysToCompute(String input) {
        if(input == null)
            return new ArrayList<Integer>();
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int p = 0;p < input.length(); p++)
        {
            char cur = input.charAt(p);
            if(cur == '+' || cur == '-' ||cur == '*')
            {
                List<Integer> left = diffWaysToCompute(input.substring(0,p));
                List<Integer> right = diffWaysToCompute(input.substring(p + 1));
                for(int i : left)
                {
                    for(int j : right)
                    {
                        int num = 0;
                        if(cur == '+')
                        {
                            num = i + j;
                        }
                        else if(cur == '-')
                        {
                            num = i - j;
                        }
                        else
                        {
                            num = i * j;
                        }
                        res.add(num);
                    }
                }
            }
        }
        if(res.size() == 0)
        {
            res.add(Integer.parseInt(input));
        }
        return res;
    }
}