// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iter;
    private Integer current;
    private boolean hasPeeked;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    iter = iterator;
	    hasPeeked = false;
	    current = null;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
	    
	    if(hasPeeked == false)
	    {
	        current = iter.next();
	        hasPeeked = true;
	    }
	    return current;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    
	    if(hasPeeked == true)
	    {
	        hasPeeked = false;
	        int res = current.intValue();
	        current = null;
	        return Integer.valueOf(res);
	    }
	    else
	    {
	        current = iter.next();
	        return current;
	    }
	}

	@Override
	public boolean hasNext() {
	    if(hasPeeked == true)
	    {
	        return true;
	    }
	    else
	    {
	        return iter.hasNext();
	    }
	}
}