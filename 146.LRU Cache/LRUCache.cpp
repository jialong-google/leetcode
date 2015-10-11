#include <list>
#include <stdio>
struct Node{
    int key;
    int value;
};
typedef struct Node NODE;

class LRUCache{
public:
    int cap;
    list<NODE> lru;
    unordered_map<int,list<NODE>::iterator> hash;
    
    LRUCache(int capacity) {
        this->cap=capacity;
    }
    
    int get(int key) {
        if(hash.find(key)!=hash.end())//find
        {
            NODE n;
            n.key=key;
            n.value=hash[key]->value;
            lru.erase(hash[key]);
            lru.push_front(n);
            hash[key]=lru.begin();
            return n.value;
        }
        else
            return -1;
    }
    
    void set(int key, int value) {
        NODE n;
        n.key=key;
        n.value=value;
        if(hash.find(key)!=hash.end())//find it.
        {
            lru.erase(hash[key]);
        }
        else if(lru.size()>=cap){
                hash.erase(lru.back().key);
                lru.pop_back();
        }
        lru.push_front(n);
        hash[key]=lru.begin();
    }
};
