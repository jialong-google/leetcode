/**
 * Definition for a point.
 * struct Point {
 *     int x;
 *     int y;
 *     Point() : x(0), y(0) {}
 *     Point(int a, int b) : x(a), y(b) {}
 * };
 */
class Solution {
public:
    int maxPoints(vector<Point>& points) {
        int large=0;
        for(int i=0;i<points.size();i++){
            unordered_map<double,int> hash;
            int same(0),ver(0),localmax(0);
            for(int j=i+1;j<points.size();j++){
                //same
                if(points[i].x==points[j].x && points[i].y==points[j].y)
                    same++;
                else if(points[i].x== points[j].x)//ver
                    ver++;
                else{//hash
                    double k=((double)(points[i].y-points[j].y))/((double)(points[i].x-points[j].x));
                    hash[k]++;
                    localmax=max(localmax,hash[k]);
                }
            }
            localmax=max(localmax,ver);
            large=max(large,localmax+same+1);
        }
        return large;
    }
};
