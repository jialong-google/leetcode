/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    private List<Interval> res = new ArrayList<Interval>();
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 0)
        {
            return res;
        }
        Collections.sort(intervals, new Comparator<Interval>()
        {
            public int compare(Interval o1, Interval o2)
            {
                if(o1.start == o2.start && o1.end == o2.end)
                    return 0;
                if(o1.start == o2.start)
                {
                    return o1.end < o2.end ? -1: 1;
                }
                else 
                {
                    return o1.start < o2.start? -1: 1;
                }
            }
        });
        Interval current = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++)
        {
            if(current.end >= intervals.get(i).start)
            {
                current.end = intervals.get(i).end < current.end ? current.end : intervals.get(i).end;
            }
            else
            {
                res.add(current);
                current = intervals.get(i);
            }
        }
        res.add(current);
        return res;
    }
}