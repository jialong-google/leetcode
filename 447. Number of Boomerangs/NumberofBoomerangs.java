public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        if(points == null || points.length == 0 || points[0] == null || points[0].length == 0)
        {
            return 0;
        }
        int res = 0;

        for(int i = 0; i < points.length; i++)
        {
            Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
            for(int j = 0; j < points.length; j++)
            {
                if(i == j)
                    continue;
                int distance = (points[i][0] - points[j][0])*(points[i][0] - points[j][0]) +(points[i][1] - points[j][1])*(points[i][1] - points[j][1]);
                Integer freq = hash.get(distance);
                if(freq == null)
                {
                    hash.put(distance, 1);
                }
                else
                {
                    res += freq;
                    hash.put(distance, freq + 1);
                }
            }
        }
        return res * 2;
    }
}