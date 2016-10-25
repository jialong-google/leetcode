public class Solution {
    private class Cell{
        int num;
        int frequency;
        Cell(int num, int frequency)
        {
            this.num = num;
            this.frequency = frequency;
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        if(k > nums.length || k <= 0)
            return new ArrayList<Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        PriorityQueue<Cell> heap = new PriorityQueue<Cell>(k, new Comparator<Cell>(){
            public int compare(Cell o1, Cell o2)
            {
                if(o1.frequency == o2.frequency)
                    return 0;
                return o1.frequency < o2.frequency ? -1: 1;
            }
        });
        Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++)
        {
            Integer cur = counter.get(nums[i]);
            if(cur == null)
            {
                counter.put(nums[i], 1);
            }
            else
            {
                counter.put(nums[i], cur + 1);
            }
        }
        int i = 0;
        for(Map.Entry<Integer, Integer> entry: counter.entrySet())
        {
            if(heap.size() < k)
            {
                heap.offer(new Cell(entry.getKey(), entry.getValue()));
            }
            else
            {
                if(entry.getValue() > heap.peek().frequency)
                {
                    heap.poll();
                    heap.offer(new Cell(entry.getKey(), entry.getValue()));
                }
            }
        }
        while(!heap.isEmpty())
        {
            res.add(heap.poll().num);
        }
        return res;
    }
}