public class Solution {
    private class Node{
        String start;
        HashMap<String, Double> end;
        Node(String one)
        {
            start = one;
            end = new HashMap<String, Double>();
        }
    }
    public double search(String start, String end, Map<String, Node> startPoints, double current, int depth)
    {
        if(depth == startPoints.size())
            return -1.0;
        if(!startPoints.containsKey(start) || !startPoints.containsKey(end))
        {
            return -1.0;
        }
        if(start.equals(end))
        {
            return current;
        }
        
        Node currentNode = startPoints.get(start);
        for(Map.Entry<String, Double> to : currentNode.end.entrySet())
        {
            double temp = search(to.getKey(), end, startPoints, current * to.getValue(), depth + 1);
            if(temp != -1.0)
                return temp;
        }
        return -1.0;
    }
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Node> startPoints = new HashMap<String, Node>();
        for(int i = 0; i < equations.length; i++)
        {
            //first node;
            Node first = startPoints.get(equations[i][0]);
            if(first == null)
            {
                first = new Node(equations[i][0]);
                startPoints.put(equations[i][0], first);
            }
            
            first.end.put(equations[i][1],values[i]);
            //second node;
            Node second = startPoints.get(equations[i][1]);
            if(second == null)
            {
                second = new Node(equations[i][1]);
                startPoints.put(equations[i][1], second);
            }
            if(values[i] != 0.0)
                second.end.put(equations[i][0], 1.0 /values[i]);
        }
        //search queries result.
        double[] res = new double[queries.length];
        for(int i = 0; i < queries.length; i++)
        {
            res[i] = search(queries[i][0], queries[i][1], startPoints, 1.0, 0);
        }
        return res;
    }
}