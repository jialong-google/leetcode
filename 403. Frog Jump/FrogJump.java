public class Solution {
    public boolean canCross(int[] stones) {
        if(stones == null || stones.length == 0)
        {
            return true;
        }
        Map<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
        map.put(0, new HashSet<Integer>());
        map.get(0).add(1);
        
        for(int i = 1; i < stones.length; i++)
        {
            map.put(stones[i], new HashSet<Integer>());
        }
        for(int i = 0; i < stones.length; i++)
        {
            HashSet<Integer> current = map.get(stones[i]);
            for(Integer step: current)
            {
                int nextStep = stones[i] + step;
                if(nextStep == stones[stones.length - 1])
                {
                    return true;
                }
                HashSet<Integer> temp = map.get(nextStep);
                if(temp != null)
                {
                    temp.add(step);
                    temp.add(step + 1);
                    if(step > 1)
                    {
                        temp.add(step - 1);
                    }
                }
            }
        }
        return false;

    }
}