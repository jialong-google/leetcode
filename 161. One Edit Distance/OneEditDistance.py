class Solution(object):
    def isOneEditDistance(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        
        if not s and not t:
            return False
        lens,lent=len(s),len(t)
        if abs(lens-lent)>1:
            return False
        i,j=0,0
        count=0
        while i<lens and j<lent:
            if s[i]==t[j]:
                i+=1
                j+=1
            else:
                count+=1
                if count==2:
                    return False
                elif lens<lent:
                    j+=1
                elif lent<lens:
                    i+=1
                else:
                    i+=1
                    j+=1
        if (count==1 and (i==lens and j==lent))or (count==0 and (i<lens or j<lent)):
            return True
        else:
            return False