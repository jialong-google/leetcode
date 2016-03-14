class Solution(object):
    def multiply(self, A, B):
        """
        :type A: List[List[int]]
        :type B: List[List[int]]
        :rtype: List[List[int]]
        """
        C=[[0 for i in range(len(B[0]))]for j in range(len(A))]
        for i in range(len(A)):
            for j in range(len(A[0])):
                if(A[i][j]):
                    for k in range(len(B[0])):
                        C[i][k]+=A[i][j]*B[j][k]
        return C