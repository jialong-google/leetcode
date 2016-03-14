class Solution(object):
    def shortestDistance(self, words, word1, word2):
        """
        :type words: List[str]
        :type word1: str
        :type word2: str
        :rtype: int
        """
        w1,w2=-999,-999
        dis=999
        for i in range(len(words)):
            if words[i]==word1 and w2==-999:
                w1=i
            elif words[i]==word2 and w1==-999:
                w2=i
            elif words[i]==word1 and w2!=-999:
                dis=min(dis,abs(w2-i))
                w1=i
            elif words[i]==word2 and w1!=-999:
                dis=min(dis,abs(w1-i))
                w2=i
        return dis