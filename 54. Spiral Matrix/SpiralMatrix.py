class Solution(object):
    def spiralOrder(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        if not matrix or matrix[0]==None:
            return []
        row1=0
        col1=0
        row2=len(matrix)
        col2=len(matrix[0])
        ret=[]
        while(row1<=row2-1 and col1<=col2-1):
            ret+=self.onelevel(matrix,row1,row2-1,col1,col2-1)
            row1=row1+1
            row2=row2-1
            col1=col1+1
            col2=col2-1
        return ret
    def onelevel(self,matrix,row1,row2,col1,col2):
        if(row1==row2 and col1==col2):
            return [matrix[row1][col1]]
        elif(row1==row2):
            return matrix[row1][col1:col2+1]
        elif(col1==col2):
            return [i[col1] for i in matrix[row1:row2+1]]
        ret=[]
        ret+=matrix[row1][col1:col2+1]
        ret+=[i[col2] for i in matrix[row1+1:row2]]
        ret+=matrix[row2][col1:col2+1][::-1]
        ret+=[i[col1] for i in matrix[row1+1:row2][::-1]]
        return ret