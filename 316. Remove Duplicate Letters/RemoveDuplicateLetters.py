class Solution(object):
    def removeDuplicateLetters(self, s):
        """
        :type s: str
        :rtype: str
        """
        if not s:
            return ''
        counter=collections.Counter(s)
        stack=[]
        for i in s:
            counter[i]-=1
            if i not in stack:#!!!!!!!!
                while stack and i<stack[-1] and counter[stack[-1]]>0:
                    stack.pop()
            #if i not in stack:
                stack.append(i)
        return reduce(lambda x,y:x+y,stack)