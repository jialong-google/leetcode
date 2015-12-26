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
public:
    struct compInterval {
        bool operator()(const Interval &a, const Interval &b) const {
            return a.start<b.start;
        }
    };

    vector<Interval> merge(vector<Interval> &intervals) {
        sort(intervals.begin(),intervals.end(),compInterval());
        vector<Interval> ret;
        for(int i=0; i<intervals.size(); i++) {
            if(ret.empty() || ret.back().end < intervals[i].start)  // no overlap
                ret.push_back(intervals[i]);
            else   // overlap
                ret.back().end = max(ret.back().end, intervals[i].end);
        }
        return ret;
    }
};