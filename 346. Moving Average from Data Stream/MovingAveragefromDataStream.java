public class MovingAverage {

    /** Initialize your data structure here. */
    private Deque<Integer> deque;
    private long sum;
    private int size;
    public MovingAverage(int size) {
        this.size = size;
        this.sum = 0;
        this.deque = new LinkedList<Integer>();
    }
    
    public double next(int val) {
        if(deque.size() < size)
        {
            sum += val;
            deque.offerLast(val);
            return (double) sum / deque.size();
        }
        else
        {
            sum += val;
            deque.offerLast(val);
            sum -= deque.pollFirst();
            return (double) sum / size;
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */