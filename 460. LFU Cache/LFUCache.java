public class LFUCache {
    private Map<Integer, Integer> vals;// key -> val;
    private Map<Integer, Integer> counts;// key -> freq;
    private Map<Integer, LinkedHashSet<Integer>> lists;// freq -> key list
    private int c;
    private int min;
    public LFUCache(int capacity) {
        c = capacity;
        min = 0;
        vals = new HashMap< Integer, Integer>(c);
        counts = new HashMap<Integer, Integer>(c);
        lists = new HashMap<Integer, LinkedHashSet<Integer>>(c);
    }
    
    public int get(int key) {
        Integer value = vals.get(key);
        if(value == null)
        {
            return -1;
        }
        int freq = counts.get(key);
        LinkedHashSet<Integer> l1 = lists.get(freq);
        LinkedHashSet<Integer> l2 = lists.get(freq + 1);
        l1.remove(key);
        if(l2 == null)
        {
            l2 = new LinkedHashSet<Integer>();
        }
        l2.add(key);
        lists.put(freq + 1, l2);
        counts.put(key, freq + 1);
        if(min == freq && l1.isEmpty())
        {
            min ++;
        }
        return value;
    }
    
    public void set(int key, int value) {
        if(c <= 0)
            return;
        Integer val = vals.get(key);
        if(val != null)
        {
            vals.put(key, value);
            get(key);
            return ;
        }
        if(vals.size() >= c)
        {
            //evict 
            LinkedHashSet<Integer> l = lists.get(min);
            int k = l.iterator().next();
            l.remove(k);
            vals.remove(k);
            counts.remove(k);
        }
        vals.put(key, value);
        counts.put(key, 1);
        LinkedHashSet<Integer> l = lists.get(1);
        if(l == null)
        {
            l = new LinkedHashSet<Integer>();
        }
        l.add(key);
        lists.put(1, l);
        min = 1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.set(key,value);
 */