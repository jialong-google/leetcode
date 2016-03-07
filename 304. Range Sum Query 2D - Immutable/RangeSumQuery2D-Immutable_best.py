class NumMatrix(object):
    def __init__(self, matrix):
        """
        initialize your data structure here.
        :type matrix: List[List[int]]
        """
        if not matrix:
            return
        else:
            self.row=len(matrix)
        if not matrix[0]:
            return
        else:
            self.col=len(matrix[0])
        self.m=[[0] *(self.col+1) for j in range(self.row+1)]
        for j in range(1,self.row+1):
            colsum=0
            for i in range(1,self.col+1):
                colsum+=matrix[j-1][i-1]
                self.m[j][i]=colsum+self.m[j-1][i]

    def sumRegion(self, row1, col1, row2, col2):
        """
        sum of elements matrix[(row1,col1)..(row2,col2)], inclusive.
        :type row1: int
        :type col1: int
        :type row2: int
        :type col2: int
        :rtype: int
        """
        return self.m[row2+1][col2+1]+self.m[row1][col1]-self.m[row2+1][col1]-self.m[row1][col2+1]


# Your NumMatrix object will be instantiated and called as such:
# numMatrix = NumMatrix(matrix)
# numMatrix.sumRegion(0, 1, 2, 3)
# numMatrix.sumRegion(1, 2, 3, 4)