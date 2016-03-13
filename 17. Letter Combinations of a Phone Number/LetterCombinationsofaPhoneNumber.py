class Solution(object):
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        res=[]
        headup={'2':['a','b','c'],'3':['d','e','f'],'4':['g','h','i'],'5':['j','k','l'],'6':['m','n','o'],'7':['p','q','r','s'],'8':['t','u','v'],'9':['w','x','y','z']}
        def dfs(numlist,valuelist):
            if not numlist:
                res.append(valuelist)
                return
            dealwith=numlist[0]
            for i in headup[dealwith]:
                dfs(numlist[1:],valuelist+i)
        if not digits:
            return []
        dfs(digits,'')
        return res