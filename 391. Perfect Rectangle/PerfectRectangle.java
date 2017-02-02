public class Solution {
    static private class Node{
        int x;
        int y;
        Node(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
        @Override
        public int hashCode()
        {
            return x * 10 + y;
        }
        @Override
        public boolean equals(Object o1)
        {
            Node n = (Node) o1;
            if(n.x == this.x && n.y == this.y)
            {
                return true;
            }
            return false;
        }
    }
    public boolean isRectangleCover(int[][] rectangles) {
        if(rectangles == null || rectangles.length == 0 || rectangles[0] == null || rectangles[0].length == 0)
        {
            return false;
        }
        Set<Node> hash = new HashSet<Node>();
        int x1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y1 = Integer.MAX_VALUE;
        int y2 = Integer.MIN_VALUE;
        int area = 0;
        for(int[] rect : rectangles)
        {
            x1 = Math.min(x1, rect[0]);
            y1 = Math.min(y1, rect[1]);
            x2 = Math.max(x2, rect[2]);
            y2 = Math.max(y2, rect[3]);
            
            area += (rect[2] - rect[0]) * (rect[3] - rect[1]);
            
            Node point1 = new Node(rect[0], rect[1]);
            Node point2 = new Node(rect[0], rect[3]);
            Node point3 = new Node(rect[2], rect[1]);
            Node point4 = new Node(rect[2], rect[3]);
            
            if(!hash.add(point1))
                hash.remove(point1);
            if(!hash.add(point2))
                hash.remove(point2);
            if(!hash.add(point3))
                hash.remove(point3);
            if(!hash.add(point4))
                hash.remove(point4);
        }
        if(!hash.contains(new Node(x1, y1)) || !hash.contains(new Node(x1, y2))|| !hash.contains(new Node(x2, y1))|| !hash.contains(new Node(x2, y2)) || hash.size() != 4)
            return false;
        
        return area == (x2 - x1) * (y2 - y1);
    }
}