/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
class Solution {
private:
    vector<Interval> res;
public:
    vector<Interval> insert(vector<Interval>& intervals, Interval newInterval) {
        int len= intervals.size();
        int i=0;
        while(i<len){
            if(intervals[i].end < newInterval.start)//if intervals is ahead of new Interval;
            {
                res.push_back(intervals[i]);
                i++;
            }
            else if(intervals[i].start> newInterval.end)//if new Interval is ahead of intervals
            {
                res.push_back(newInterval);
                res.insert(res.end(),intervals.begin()+i,intervals.end());
                return res;
            }
            else// these two overlap.
            {
                newInterval.start=min(intervals[i].start,newInterval.start);
                newInterval.end=max(intervals[i].end,newInterval.end);
                i++;
            }
        }
        if(res.empty()||res[res.size()-1].start!= newInterval.start || res[res.size()-1].end!= newInterval.end )
            res.push_back(newInterval);
        return res;
    }
};