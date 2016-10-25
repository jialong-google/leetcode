public class MovingAverage {

    /** Initialize your data structure here. */
    private int[] deque;
    private long sum;
    private int size;
    private int pointer;
    public MovingAverage(int size) {
        this.size = 0;
        this.sum = 0;
        this.pointer = 0;
        this.deque = new int[size];
    }
    
    public double next(int val) {
        if(size < deque.length)
        {
            sum += val;
            deque[pointer] = val;
            pointer = (pointer + 1) % deque.length;
            size ++;
            return (double) sum / size;
        }
        else
        {
            sum -= deque[pointer];
            sum += val;
            deque[pointer] = val;
            pointer = (pointer + 1) % deque.length;
            return (double) sum / deque.length;
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */