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
        if lens>lent:# only one delete on lens or add on lent is allowed
            i=0
            count=0
            while(i<lent):
                if s[i+count]!=t[i]:
                    count+=1
                    if count==2:
                        return False
                    continue
                i+=1
            return True
            
            
        elif lent>lens:# only one delete on lent or add on lens is allowed
            i=0
            count=0
            while(i<lens):
                if s[i]!=t[i+count]:
                    count+=1
                    if count==2:
                        return False
                    continue
                i+=1
            return True
            
        else:#only one rewrite is allowed
            i=0
            count=0
            while(i<lens):
                if s[i]!=t[i]:
                    count+=1
                    if count==2:
                        return False
                i+=1
            if count==1:
                return True
            else:
                return False