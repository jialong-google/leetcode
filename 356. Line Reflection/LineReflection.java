public class Solution {
    public boolean isReflected(int[][] points) {
        if(points == null || points.length == 0)
            return true;
        Arrays.sort(points, new Comparator<int[] >()
        {
            public int compare(int[] o1, int[] o2)
            {
                if(o1[1] == o2[1] && o1[0] == o2[0])
                    return 0;
                if(o1[1] == o2[1])
                {
                    return o1[0] < o2[0] ? -1: 1;
                }
                return o1[1] < o2[1] ? -1: 1;
            }
        });
        int i = 0;
        int accumulate = 0;
        int count = 0;
        while( i < points.length && points[i][1] == points[0][1])
        {
            if(i == 0 || points[i - 1][0] != points[i][0])
            {
                accumulate += points[i][0];
            }
            else
            {
                count ++;
            }
            i++;
        }
        double mid = ((double)accumulate )/ (i - count);
        //System.out.println(mid);
        i = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        while(i < points.length)
        {
            int j = 0;
            while(i + j < points.length && points[i + j][1] == points[i][1])
            {
                if(points[i + j][0] == mid || ( j != 0 && (points[i + j -1][0] == points[i + j][0])))
                {
                    j++;
                    continue;
                }
                if(points[i + j][0] < mid)
                {
                    stack.offerLast(points[i + j][0]);
                }
                else if(points[i + j][0] > mid)
                {
                    if(stack.isEmpty() || stack.pollLast() != 2 * mid - points[i + j][0])
                    {
                        return false;
                    }
                }
                else
                {
                    return false;
                }
                j ++;
            }
            if(!stack.isEmpty())
            {
                return false;
            }
            i += j;
        }
        return true;
    }
}