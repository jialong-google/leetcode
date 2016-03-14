class WordDistance(object):
    def __init__(self, words):
        """
        initialize your data structure here.
        :type words: List[str]
        """
        self.dictionary=collections.defaultdict(list)
        for i in range(len(words)):
            self.dictionary[words[i]].append(i)
        

    def shortest(self, word1, word2):
        """
        Adds a word into the data structure.
        :type word1: str
        :type word2: str
        :rtype: int
        """
        word1_list=self.dictionary[word1]
        word2_list=self.dictionary[word2]
        i=j=0
        dis=999999
        while i<len(word1_list) and j<len(word2_list):
            dis=min(abs(word1_list[i]-word2_list[j]),dis)
            if word1_list[i]<word2_list[j]:
                i+=1
            else:
                j+=1
        return dis


# Your WordDistance object will be instantiated and called as such:
# wordDistance = WordDistance(words)
# wordDistance.shortest("word1", "word2")
# wordDistance.shortest("anotherWord1", "anotherWord2")