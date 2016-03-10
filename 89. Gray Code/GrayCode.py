class Solution(object):
    def grayCode(self, n):
        """
        :type n: int
        :rtype: List[int]
        """
        ans=[0]
        i=0
        while(i<n):
            tmp=[]
            for individual in ans[::-1]:
                tmp.append(individual|(0x00001<<i))
            ans+=tmp
            i+=1
        return ans