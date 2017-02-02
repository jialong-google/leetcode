public class Solution {
    private class MedianQueue{
        Queue<Integer> minQue = new PriorityQueue<Integer>();
        Queue<Integer> maxQue = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        private void add(int num)
        {
            minQue.offer(num);
            maxQue.offer(minQue.poll());
        }
        private double getMedian()
        {
            while(minQue.size() - maxQue.size() >= 1)
                maxQue.offer(minQue.poll());
            while(maxQue.size() - minQue.size() >= 1)
                minQue.offer(maxQue.poll());
            if(minQue.size() == maxQue.size())
                return ((double)minQue.peek() + (double)maxQue.peek()) / 2.0;
            else
                return minQue.peek();
        }
        private void remove(int n)
        {
            if(!minQue.remove(n))
                maxQue.remove(n);
        }
    }
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        MedianQueue queue = new MedianQueue();
        int p = 0;
        for(int i = 0; i < k; i++)
        {
            queue.add(nums[i]);
        }
        res[p++] = queue.getMedian();
        for(int i = k ; i < nums.length; i++)
        {
            queue.add(nums[i]);
            queue.remove(nums[i - k]);
            res[p++] = queue.getMedian();
        }
        return res;
    }
}