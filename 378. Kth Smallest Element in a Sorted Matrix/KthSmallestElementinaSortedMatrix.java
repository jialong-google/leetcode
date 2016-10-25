public class Solution {
    private class Cell{
        int col;
        int row;
        int num;
        Cell(int col, int row, int num){
            this.col = col;
            this.row = row;
            this.num = num;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return -1;
        int row = matrix.length;
        int col = matrix[0].length;
        if(k < 1 || k > row* col)
            return -1;
        PriorityQueue<Cell> heap = new PriorityQueue<Cell>(new Comparator<Cell>(){
            public int compare(Cell o1, Cell o2)
            {
                if(o1.num == o2.num)
                    return 0;
                return o1.num < o2.num? -1: 1;
            }
        });
        heap.offer(new Cell(0,0,matrix[0][0]));
        Cell current = null;
        while( k > 0)
        {
            current = heap.poll();
            if(current.col == 0 && current.row + 1 < row)
            {
                heap.offer(new Cell(0, current.row + 1, matrix[current.row + 1][0]));
            }
            if(current.col + 1 < col)
            {
                heap.offer(new Cell(current.col + 1, current.row, matrix[current.row][current.col + 1]));
            }
            k--;
        }
        return current.num;
    }
}