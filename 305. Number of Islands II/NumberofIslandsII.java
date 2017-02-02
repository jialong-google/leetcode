public class Solution {
    private int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<Integer>();
        int[] unionFind = new int[m *n];
        Arrays.fill(unionFind, -1); 
        int count = 0;
        for(int i = 0; i < positions.length; i++)
        {
            int pos = positions[i][0] * n + positions[i][1];
            unionFind[pos] = pos;
            count ++;
            for(int[] j : dirs)
            {
                int x = positions[i][0] + j[0];
                int y = positions[i][1] + j[1];
                if(x >= 0 && y >= 0 && x < m && y < n && unionFind[x*n +y] != -1 )
                {
                    int temp = find(unionFind, x*n + y);
                    int temp2 = find(unionFind, pos);
                    if( temp2 != temp)
                    {
                        unionFind[temp2] = temp; // must to the root.
                        count --;
                    }
                }
            }
            res.add(count);
        }
        return res;
    }
    public int find(int[] array, int id)
    {
        while(array[id] != id)
        {
            id = array[id];
        }
        return id;
    }
}