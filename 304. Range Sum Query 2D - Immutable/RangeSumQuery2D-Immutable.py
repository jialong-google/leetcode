class NumMatrix(object):
    def __init__(self, matrix):
        """
        initialize your data structure here.
        :type matrix: List[List[int]]
        """
        if matrix==None or not matrix:
            return
        else:
            self.row=len(matrix)
        if not matrix[0] or matrix[0]==None:
            return
        else:
            self.col=len(matrix[0])
        self.m=[[0 for i in range(self.col)]for j in range(self.row)]
        for j in range(len(matrix)):
            s=0
            for i in range( len(matrix[j])):
                s+=matrix[j][i]
                self.m[j][i]=s

    def sumRegion(self, row1, col1, row2, col2):
        """
        sum of elements matrix[(row1,col1)..(row2,col2)], inclusive.
        :type row1: int
        :type col1: int
        :type row2: int
        :type col2: int
        :rtype: int
        """
        r=0
        if row1>=self.row or row2>=self.row or col1>self.col or col2>self.col:
            return -1
        for i in range(row1,row2+1):
            r+=self.m[i][col2]-(self.m[i][col1-1] if col1-1>=0 else 0)
        return r
        


# Your NumMatrix object will be instantiated and called as such:
# numMatrix = NumMatrix(matrix)
# numMatrix.sumRegion(0, 1, 2, 3)
# numMatrix.sumRegion(1, 2, 3, 4)