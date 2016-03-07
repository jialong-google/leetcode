class Solution(object):
    m={}
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        self.m[0]=1.0
        self.m[1]=x
        if n <0:
            return 1.0/self.myPow(x,-n)
        if n in self.m:
            return self.m[n]
        if n>=2:
            n1=n/2
            n2=n-n1
            if (n1 not in self.m):
                self.m[n1]=self.myPow(x,n1)
                #print n1
            if(n2 not in self.m):
                self.m[n2]=self.myPow(x,n2)
                #print n2
            self.m[n]=self.m[n1]*self.m[n2]
            return  self.m[n]