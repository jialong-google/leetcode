class Solution(object):
    def mySqrt(self, x):
        """
        :type x: int
        :rtype: int
        """
        i=0
        j=x
        while(i<=j):###!!!
            mid=(i+j)/2
            if mid**2==x:
                return mid
            elif mid**2<x:
                i=mid+1
            else:
                j=mid-1
        return j