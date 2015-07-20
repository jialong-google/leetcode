class Solution {
public:
    int longestValidParentheses(string s) {
        stack<int> left;
        const int len=s.length();
        int last=-1;
        int large=0;
        for(int i=0;i<len;i++){
            if(s[i]=='(')
            {
                left.push(i);
            }
            else{//s[i]==')'
                if(left.size()>1){
                    left.pop();
                    large=max(large,i-left.top());//!!!!
                }
                else if(left.size()==1){
                    left.pop();
                    large=max(large,i-last);
                }
                else if(left.empty()){
                    last=i;
                }
            }
        }
     return large;   
    }
};
