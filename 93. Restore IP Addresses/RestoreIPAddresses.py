class Solution(object):
    def restoreIpAddresses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        if len(s)>12:
            return []
        self.ans=[]
        def dfs(remain,depth,valuelist):
            if depth>4:
                return
            if depth==4 and remain=='': #and valuelist[:-1] not in self.ans:
                self.ans.append(valuelist[:-1])
                return 
            else:
                for i in range(1,min(4,len(remain)+1)):
                    if remain[:i] and int(remain[:i])<=255:
                        dfs(remain[i:],depth+1,valuelist+remain[:i]+'.')
                    if remain and remain[0]=='0':###!!!
                        break
        dfs(s,0,'')
        return self.ans