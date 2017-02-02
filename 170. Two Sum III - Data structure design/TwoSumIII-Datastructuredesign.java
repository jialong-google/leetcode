public class TwoSum {

    // Add the number to an internal data structure.
    private Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
	public void add(int number) {
	    Integer freq = hash.get(number);
	    if(freq == null)
	    {
	        hash.put(number, 1);
	    }
	    else
	    {
	        hash.put(number, freq + 1);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for(Integer i: hash.keySet())
	    {
	        if(hash.get(value - i) != null && !(value == 2 * i && hash.get(i) <= 1))
    	        return true;
	    }
	    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);