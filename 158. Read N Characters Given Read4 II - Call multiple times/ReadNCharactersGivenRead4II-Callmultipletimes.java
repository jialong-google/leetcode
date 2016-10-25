/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
     //this shouldn't be static since if it does, all instance from solution will share just one copy.
     public Queue<Character> queue = new LinkedList<Character>();
     
    public int read(char[] buf, int n) {
        int read = 0;
        while(!queue.isEmpty() && read < n)
        {
            buf[read++] = queue.poll();
        }
        while(read < n)
        {
            char[] current = new char[4];
            int readOut = read4(current);
            if(read + readOut > n)
            {
                for(int i = n - read; i < readOut; i++)// and pay attention to the parameter here.
                {
                    //System.out.println(current[i] + " in queue");
                    queue.offer(current[i]);
                }
            }
            for(int i = 0; i < readOut && read < n; i++)
            {
                buf[read++] = current[i];
            }
            if(readOut < 4)
            {
                break;
            }
        }
        return read;
    }
}