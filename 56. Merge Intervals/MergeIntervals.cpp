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
    //pay attention!!
    struct comp{
        bool operator()(Interval &i1,Interval &i2){
            return i1.start<i2.start;
        }
    };
    vector<Interval> merge(vector<Interval>& intervals) {
        vector<Interval> res;
        if(intervals.empty() || intervals.size()<=1)
            return intervals;
        sort(intervals.begin(),intervals.end(),comp());
        int len=intervals.size();
        Interval me(-999,-999);
        for(int i=0;i<len;i++)
        {
            if(me.start==-999 && me.end==-999)//me is empty
            {
                me=intervals[i];
            }
            else if(me.end < intervals[i].start){// not overlap. push_back me.
                res.push_back(me);
                me.start=-999;
                me.end=-999;
                i--;
            }
            //else if(me.start> intervals[i].end){// not overlap. push_back interval.
            //    res.push_back(intervals[i]);
            //}
            else// overlap. Merge the two.
            {
                me.start=min(intervals[i].start, me.start);
                me.end= max(intervals[i].end, me.end);
            }
        }
        if(me.start!=-999 || me.end!=-999)
            res.push_back(me);
        
        return res;
    }
};