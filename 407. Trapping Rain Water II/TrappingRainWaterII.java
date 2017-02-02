public class Solution {
    private class Cell{
        int x;
        int y;
        int height;
        Cell(int x, int y, int h)
        {
            this.x = x;
            this.y = y;
            height = h;
        }
    }
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    public int trapRainWater(int[][] heightMap) {
        if(heightMap == null || heightMap.length <= 2 || heightMap[0] == null || heightMap[0].length <= 2)
        {
            return 0;
        }
        int count = 0;
        boolean[][] visited = new boolean[heightMap.length][heightMap[0].length];
        PriorityQueue<Cell> heap = new PriorityQueue<Cell>(1, new Comparator<Cell>()
        {
            public int compare(Cell o1, Cell o2)
            {
                if(o1.height == o2.height)
                    return 0;
                return o1.height < o2.height? -1 : 1;
            }
        });
        // put the border into the heap.
        for(int i = 0; i < heightMap.length ; i++)
        {
            visited[i][heightMap[0].length - 1] = true;
            visited[i][0] = true;
            heap.offer(new Cell(i, heightMap[0].length - 1, heightMap[i][heightMap[0].length - 1]));
            heap.offer(new Cell(i, 0, heightMap[i][0]));
        }
        for(int j = 0; j < heightMap[0].length ; j++)
        {
            visited[heightMap.length -1][j] = true;
            visited[0][j] = true;
            heap.offer(new Cell(heightMap.length -1, j, heightMap[heightMap.length -1][j]));
            heap.offer(new Cell(0, j, heightMap[0][j]));
        }
        
        while(!heap.isEmpty())
        {
            Cell current = heap.poll();
            for(int i = 0; i < 4; i++)
            {
                int x = current.x + dx[i];
                int y = current.y + dy[i];
                if(x < 0 || x >= heightMap.length || y < 0 || y >= heightMap[0].length || visited[x][y])
                {
                    continue;
                }
                visited[x][y] = true;
                count += Math.max(current.height - heightMap[x][y], 0);
                heap.offer(new Cell(x, y, Math.max(current.height, heightMap[x][y])));
            }
        }
        return count;
    }
    
}