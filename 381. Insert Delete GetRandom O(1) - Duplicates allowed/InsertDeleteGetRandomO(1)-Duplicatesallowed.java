public class RandomizedCollection {
    Map<Integer, Set<Integer>> locs;
    List<Integer> nums;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        nums = new ArrayList<Integer>();
        locs = new HashMap<Integer, Set<Integer>>();
        
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        Set<Integer> temp = locs.get(val);
        if(temp == null || temp.isEmpty())
        {
            temp = new LinkedHashSet<Integer>();
            temp.add(nums.size());
            nums.add(val);
            locs.put(val, temp);
            return true;
        }
        temp.add(nums.size());
        nums.add(val);
        return false;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        Set<Integer> temp = locs.get(val);
        if(temp == null || temp.isEmpty())
        {
            return false;
        }
        int tobedelete = temp.iterator().next();
        temp.remove(tobedelete);
        if(tobedelete != nums.size() - 1)
        {
            int lastnum = nums.get(nums.size() - 1);
            locs.get(lastnum).remove(nums.size() - 1);
            locs.get(lastnum).add(tobedelete);
            nums.set(tobedelete,lastnum);
        }
        nums.remove(nums.size() - 1);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get((int)(Math.random()* (nums.size())));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */