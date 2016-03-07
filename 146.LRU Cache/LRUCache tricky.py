class LRUCache(object):

    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.capacity=capacity
        self.h=collections.OrderedDict()

    def get(self, key):
        """
        :rtype: int
        """
        if key not in self.h:
            return -1
        v=self.h.pop(key)
        self.h[key]=v
        return v
        

    def set(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: nothing
        """
        if key in self.h:
            self.h.pop(key)
        elif self.capacity==len(self.h):
            self.h.popitem(last=False)
        self.h[key]=value