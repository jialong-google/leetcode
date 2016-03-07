class TrieNode(object):
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.value=0
        self.children={}
        

class Trie(object):

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: void
        """
        p=self.root
        for i in word:
            if i not in p.children:
                p.children[i]=TrieNode()
            p=p.children[i]
        p.value=1


    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        p=self.root
        for i in word:
            if i not in p.children:
                return False
            p=p.children[i]
        if p.value ==1:
            return True
        else:
            return False

    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie
        that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        p=self.root
        for i in prefix:
            if i not in p.children:
                return False
            p=p.children[i]
        return True
    def after(self, prefix):
        s=""
        p=self.root
        for i in prefix:
            print i
            if i not in p.children:
                return False
            p=p.children[i]
        while(True):
            if len((p.children))>1:
                return s
            elif len(p.children)==1:
                s+=str(p.children.keys()[0])
                p=p.children[p.children.keys()[0]]
            else:
                break
        return s

# Your Trie object will be instantiated and called as such:
trie = Trie()
trie.insert("somestring")
trie.insert("something")
trie.insert("somestrng")
print trie.search("key")
#print trie.after("some")
print trie.after("somet")
