class Solution(object):
    def findRepeatedDnaSequences(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        def strToint(s):
            integer=0
            for i in s:
                integer=(integer<<2)|translate[i]
            return integer
        translate={'A':0,'C':1,'G':2,'T':3}
        hashset=collections.defaultdict(int)
        ans=[]
        if not s:
            return ans
        slice=strToint(s[0:10])
        hashset[slice]=1
        for index in range(10,len(s)):
            slice=((slice<<2)|translate[s[index]])&0xFFFFF
            hashset[slice]+=1
            if hashset[slice]==2:
                ans.append(s[index-9:index+1])
        return ans