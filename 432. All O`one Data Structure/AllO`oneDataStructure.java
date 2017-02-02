public class AllOne {

    private class Node{
        Node pre;
        Node next;
        int count;
        Set<String> keys;
        Node(int c)
        {
            count = c;
            keys = new LinkedHashSet<String>();
        }
    }
    private Node min;
    private Node max;
    private Map<Integer, Node> freqToNode;
    private Map<String, Integer> keyToFreq;
    
    /** Initialize your data structure here. */
    public AllOne() {
        min = new Node(Integer.MIN_VALUE);
        max = new Node(Integer.MAX_VALUE);
        min.next = max;
        max.pre = min;
        freqToNode = new HashMap<Integer, Node>();
        keyToFreq = new HashMap<String, Integer>();
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        Integer freq = keyToFreq.get(key);
        if(freq == null)// insert a new one with freq 1.
        {
            Node current = freqToNode.get(1);
            if(current == null)
            {
                current = new Node(1);
                current.next = min.next;
                current.pre = min;
                min.next.pre = current;
                min.next = current;
                freqToNode.put(1, current);
            }
            current.keys.add(key);
            keyToFreq.put(key, 1);
        }
        else// increase the key.
        {
            Node current = freqToNode.get(freq);
            Node current2 = freqToNode.get(freq + 1);
            if(current2 == null)
            {
                current2 = new Node(freq + 1);
                current2.next = current.next;
                current2.pre = current;
                current.next = current2;
                current2.next.pre = current2;
                freqToNode.put(freq + 1, current2);
            }
            current2.keys.add(key);
            keyToFreq.put(key, freq + 1);
            current.keys.remove(key);
            if(current.keys.size() == 0)
            {
                current.pre.next = current.next;
                current.next.pre = current.pre;
                freqToNode.remove(freq);
            }
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        Integer freq = keyToFreq.get(key);
        if(freq != null)
        {
            Node current = freqToNode.get(freq);
            if(freq != 1)
            {
                Node current2 = freqToNode.get(freq - 1);
                if(current2 == null)
                {
                    current2 = new Node(freq - 1);
                    current2.next = current;
                    current2.pre = current.pre;
                    current.pre = current2;
                    current2.pre.next = current2;
                    freqToNode.put(freq - 1, current2);
                }
                current2.keys.add(key);
                keyToFreq.put(key, freq - 1);
            }
            else//freq == 1
            {
                keyToFreq.remove(key);
            }
            current.keys.remove(key);
            if(current.keys.size() == 0)
            {
                current.pre.next = current.next;
                current.next.pre = current.pre;
                freqToNode.remove(freq);
            }
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if(max.pre == min)
        {
            return "";
        }
        else
        {
            return max.pre.keys.iterator().next();
        }
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if(min.next == max)
        {
            return "";
        }
        else
        {
            return min.next.keys.iterator().next();
        }
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */