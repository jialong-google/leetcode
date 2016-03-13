class Solution(object):
    def nthUglyNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        ans=[1]
        L=[0,0,0]
        ugly=[2,3,5]
        while len(ans)<n:
            tmp1,tmp2,tmp3=ans[L[0]]*2,ans[L[1]]*3,ans[L[2]]*5
            tmp=min(min(tmp1,tmp2),tmp3)
            if tmp==tmp1:
                L[0]+=1
            if tmp==tmp2:
                L[1]+=1
            if tmp==tmp3:
                L[2]+=1
            ans.append(tmp)
        return ans[n-1]