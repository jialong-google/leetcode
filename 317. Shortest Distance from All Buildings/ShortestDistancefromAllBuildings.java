public class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {-1, 1, 0, 0};
    public class Node
    {
        int x;
        int y;
        int dist;
        public Node(int x, int y, int dist)
        {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    public int shortestDistance(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return 0;
        List<Node> buildings = new ArrayList<Node>();
        int[][] dist = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 1)
                    buildings.add(new Node(i, j, 0));
            }
        }
        for(int i = 0; i < buildings.size(); i++)
        {
            bfs(grid, dist, buildings.get(i), i);
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(-grid[i][j] == buildings.size())
                {
                    res = Math.min(dist[i][j], res);
                }
            }
        }
        if(res == Integer.MAX_VALUE)
            return -1;
        return res;
        
    }
    public void bfs(int[][] grid, int[][] dist, Node cur, int depth)
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(cur);
        while(!queue.isEmpty()){
            Node current = queue.poll();
            dist[current.x][current.y] += current.dist;
            //you cannot put -=1 here.
            for(int i = 0; i < 4; i++)
            {
                int x = current.x + dx[i];
                int y = current.y + dy[i];
                if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] > 0 )
                    continue;
                if(grid[x][y] == -depth)
                {
                    grid[x][y] -= 1;//!!!! 
                    Node next = new Node(x, y, current.dist + 1);
                    queue.offer(next);
                }
            }
        }
    }
}