/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int read = 0;
        //buf = new char[n];
        while(read < n)
        {
            char[] readOut = new char[4];
            int currentReadOut = read4(readOut);
            for(int i = 0; read < n && currentReadOut != i; i++)
            {
                buf[read++] = readOut[i];
            }
            if(currentReadOut != 4)
            {
                break;
            }
        }
        return read;
    }
}