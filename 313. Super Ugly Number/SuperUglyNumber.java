public class Solution {
    public class Cell
    {
        int value;
        int prime;
        int index;
        
        public Cell(int value, int prime, int index)
        {
            this.value = value;
            this.prime = prime;
            this.index = index;
        }
    }
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n <= 1)
            return 1;
        int[] nums = new int[n];
        nums[0] = 1;
        PriorityQueue<Cell> heap = new PriorityQueue<Cell>( new Comparator<Cell>(){
            @Override
            public int compare(Cell o1, Cell o2){
                if(o1.value == o2.value)
                    return 0;
                return o1.value < o2.value? -1: 1;
            }
        });
        
        for(int i = 0; i < primes.length ; i++)
        {
            heap.offer(new Cell(primes[i], primes[i], 0));
        }
        for(int i = 1; i < n; i++)
        {
            Cell cur = heap.poll();
            nums[i] = cur.value;
            cur.value = nums[++ cur.index ] * cur.prime;
            heap.offer(cur);
            while(!heap.isEmpty() && nums[i] == heap.peek().value)
            {
                cur = heap.poll();
                cur.value = nums[++cur.index] * cur.prime;
                heap.offer(cur);
            }
        }
        return nums[nums.length - 1];
    }
}