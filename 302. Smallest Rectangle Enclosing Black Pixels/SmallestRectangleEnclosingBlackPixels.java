public class Solution {
    private int searchCol(char[][] image, int begin, int end, int x, int y, boolean first)
    {
        while(begin < end)
        {
            int k = x;
            int mid = begin + (end - begin) / 2;
            while(k < y && image[k][mid] == '0') k ++;
            if(k < y == first)
            {
                end = mid;
            }
            else
            {
                begin = mid + 1;
            }
        }
        return begin;
    }
    private int searchRow(char[][] image, int low, int high , int x, int y, boolean first)
    {
        while(low < high)
        {
            int k = x;
            int mid = low +(high - low) /2; 
            while(k < y && image[mid][k] == '0') k ++;
            if(k < y == first)
            {
                high = mid;
            }
            else
            {
                low = mid + 1;
            }
        }
        return low;
    }
    public int minArea(char[][] image, int x, int y) {
        if(image == null || image.length == 0 || image[x][y] != '1')
        {
            return 0;
        }
        int n = image.length;
        int m = image[0].length;
        int left = searchCol(image, 0, y, 0, n, true);
        int right = searchCol(image, y + 1, m, 0, n , false);
        int up = searchRow(image, 0, x, 0, m, true);
        int down = searchRow(image, x+ 1, n, 0, m, false);
        return (right - left) * (down - up);
    }
}