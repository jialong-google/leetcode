class Solution {
private:
        int res=0;
public:
    int largestRectangleArea(vector<int>& height) {
        stack<int> s;
        int len=height.size();
        height.push_back(0);
        for(int i=0;i<len+1;i++){
            if(s.empty() || height[i]>height[s.top()])
                s.push(i);
            else{
                int t=s.top();
                s.pop();
                res=max(res, height[t]*(s.empty()? i:i-s.top()-1));
                i--;
            }
        }
        return res;
    }
};