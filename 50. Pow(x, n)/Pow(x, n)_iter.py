class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        m=abs(n)
        res=1.0
        while(m!=0):
            if(m%2):
                res=res*x
            x=x*x
            m=m/2
        if n>=0:
            return res
        if n<0:
            return 1.0/res