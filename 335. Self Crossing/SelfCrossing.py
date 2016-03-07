class Solution(object):
    def isSelfCrossing(self, x):
        """
        :type x: List[int]
        :rtype: bool
        """
        for index in range(3,len(x)):
            if x[index]>=x[index-2] and x[index-1]<=x[index-3]:
                return True
            if index>=4 and x[index-3]==x[index-1]and x[index-2]<=x[index-4]+x[index]:
                return True
            if index>=5 and x[index]+x[index-4]>=x[index-2] and x[index-3]-x[index-5]<=x[index-1]<=x[index-3] and x[index-2]>x[index-4]:
                return True
        return False