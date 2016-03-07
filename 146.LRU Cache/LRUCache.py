class Node(object):
    def __init__(self,key,value):
        self.key=key
        self.value=value
        self.prev=None
        self.next=None


class LRUCache(object):

    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.capacity=capacity
        self.h={}
        self.front=Node('f','f')
        self.tail=Node('t','t')
        self.front.next=self.tail
        self.tail.front=self.front

    def get(self, key):
        """
        :rtype: int
        """
        if key not in self.h:
            return -1
        self.insertFront(self.unlink(self.h[key]))
        return self.h[key].value

    def set(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: nothing
        """
        if key in self.h:
            self.insertFront(self.unlink(self.h[key]))
            self.h[key].value=value
        else:
            if len(self.h)>=self.capacity:
                del self.h[self.unlink(self.h[self.tail.prev.key]).key]
            self.h[key]=Node(key,value)
            self.insertFront(self.h[key])
            
    def unlink(self,Node):
        Node.prev.next=Node.next
        Node.next.prev=Node.prev
        Node.next=None
        Node.prev=None
        return Node
        
    def insertFront(self,Node):
        self.front.next.prev=Node
        Node.next=self.front.next
        self.front.next=Node
        Node.prev=self.front