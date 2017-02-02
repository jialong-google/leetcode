public class RandomizedSet {

    /** Initialize your data structure here. */
    private List<Integer> nums;
    private Map<Integer, Integer> map;
    private int capacity;
    Random rand = new Random();
    
    public RandomizedSet() {
        nums = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
        capacity = 0;
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        Integer temp = map.get(val);
        if(temp != null)
            return false;
        map.put(val, capacity);
        nums.add(capacity, val);
        capacity ++;
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        Integer tobedelete = map.get(val);
        if(tobedelete == null)
            return false;
        int last = nums.get(capacity - 1);
        nums.set(tobedelete, last);
        map.put(last, tobedelete);
        map.put(val, null);
        capacity --;
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get( rand.nextInt(capacity) );
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */