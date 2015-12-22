class Solution {
public:
    int maximalRectangle(vector<vector<char>>& matrix) {
        if(matrix.empty() || matrix[0].empty() )
            return 0;
        int m=matrix.size();
        int n=matrix[0].size();
        int res=0;
        vector<int> first(n,0);
        for(int i=0;i<m;i++)
        {    
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]=='1')
                    first[j]++;
                else
                    first[j]=0;
            }

            res=max(res,largestRectangleArea(first));
        }
        return res;
    }
    int largestRectangleArea(vector<int>& height) {
        stack<int> s;
        int len=height.size();
        int res=0;
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