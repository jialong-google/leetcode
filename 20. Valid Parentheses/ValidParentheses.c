class Solution {
private:
    stack<char> ss;
public:
    bool isValid(string s) {
        int len=s.length();
        for(int i=0;i<len;i++)
        {
            if(s[i]==')')
                if(!ss.empty() &&ss.top()=='(')
                    ss.pop();
                else
                    return false;
            else if(s[i]=='}')
                if(!ss.empty() &&ss.top()=='{')
                    ss.pop();
                else
                    return false;
            else if(s[i]==']')
                if(!ss.empty() &&ss.top()=='[')
                    ss.pop();
                else
                    return false;
            else
                ss.push(s[i]);
        }
        if(ss.empty())
            return true;
        else
            return false;
        
    }
};