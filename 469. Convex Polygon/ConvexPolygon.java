public class Solution {
    private long cross(List<Integer> a, List<Integer> b, List<Integer> c)
    {
        return (a.get(0) - c.get(0)) * (b.get(1) - c.get(1)) - (a.get(1) - c.get(1)) *(b.get(0) - c.get(0)); 
    }
    public boolean isConvex(List<List<Integer>> points) {
        if(points == null || points.size() < 3)
        {
            return false;
        }
        long last = 0;
        for(int i = 0; i < points.size(); i++)
        {
            List<Integer> a = points.get(i);
            List<Integer> b = points.get((i + 1)% points.size());
            List<Integer> c = points.get((i + 2)% points.size());
            long res = cross(a, b, c);
            if(res != 0)
            {    if(res * last < 0)
                    return false;
                last = res;
            }
        }
        return true;
    }
}