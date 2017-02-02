/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class SummaryRanges {
    TreeMap<Integer, Interval> tree;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        tree = new TreeMap<Integer, Interval>();
    }
    
    public void addNum(int val) {
        if(tree.containsKey(val))
            return;
        Integer l = tree.lowerKey(val);
        Integer h = tree.higherKey(val);
        if(l != null && h != null && tree.get(l).end + 1 == val && val + 1 == h)//merge l and h.
        {
            Interval current = new Interval(l, tree.get(h).end);
            tree.put(l, current);
            tree.remove(h);
        }
        else if(l != null && tree.get(l).end + 1 >= val)// merge to l
        {
            tree.get(l).end = Math.max(val, tree.get(l).end);
        }
        else if(h != null && val + 1 == h)//merge to h
        {
            Interval current = new Interval(val, tree.get(h).end);
            tree.put(val, current);
            tree.remove(h);
        }
        else// cannot be merged.
        {
            tree.put(val, new Interval(val, val));
        }
    }
    
    public List<Interval> getIntervals() {
        return new ArrayList<Interval>(tree.values());
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */