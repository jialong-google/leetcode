class Node(object):
    def __init__(self,end=0):
        self.end=end
        self.children={}

class WordDictionary(object):
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.dummpy=Node(0)
        
    def addWord(self, word):
        """
        Adds a word into the data structure.
        :type word: str
        :rtype: void
        """
        current=self.dummpy
        for i in word:
            if i not in current.children:
                node=Node()
                current.children[i]=node
            current=current.children[i]
        current.end=1

    def search_helper(self,word,node):
        if (not word) and (node.end==1):
            return True
        current=node
        for i in range(len(word)):
            if not word[i]== '.':
                if word[i] not in current.children.keys():
                    return False
                else:
                    current=current.children[word[i]]
            else:
                for k in current.children.keys():
                    if self.search_helper(word[i+1:],current.children[k])==True:
                        return True
                return False
        if(current.end==1):
            return True
        else:
            return False
    
    def search(self, word):
        """
        Returns if the word is in the data structure. A word could
        contain the dot character '.' to represent any one letter.
        :type word: str
        :rtype: bool
        """
        current=self.dummpy
        return self.search_helper(word,current)
        

# Your WordDictionary object will be instantiated and called as such:
# wordDictionary = WordDictionary()
# wordDictionary.addWord("word")
# wordDictionary.search("pattern")