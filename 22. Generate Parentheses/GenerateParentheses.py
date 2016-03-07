class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        self.strlist=''
        self.re=[]
        self.helper('('*n,')'*n,self.strlist,self.re)
        return self.re
    def helper(self,left,right,strl,re):
        if (left=='') and (right==''):
            re.append(strl)
            return
        if len(left)<len(right):
            self.helper(left,right[:-1],strl+')',re)
        if len(left)>=1:
            self.helper(left[:-1],right,strl+'(',re)