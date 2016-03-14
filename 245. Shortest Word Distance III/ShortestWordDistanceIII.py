class Solution(object):
    def shortestWordDistance(self, words, word1, word2):
        """
        :type words: List[str]
        :type word1: str
        :type word2: str
        :rtype: int
        """
        dis=len(words)
        if word1==word2:
            index=999999
            for i in range(len(words)):
                if words[i]==word1:
                    dis=min(abs(index-i),dis)
                    index=i
            return dis
        else:
            w1,w2=-9999999,-9999999
            for i in range(len(words)):
                if words[i]==word1 and w2==-9999999:
                    w1=i
                elif words[i]==word2 and w1==-9999999:
                    w2=i
                elif words[i]==word1 and w2!=-9999999:
                    dis=min(dis,abs(w2-i))
                    w1=i
                elif words[i]==word2 and w1!=-9999999:
                    dis=min(dis,abs(w1-i))
                    w2=i
            return dis