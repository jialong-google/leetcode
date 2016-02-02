class Solution {
public:
    void reverseWords(string &s) {
        vector<string> result;
        if(s.empty())
            return;
        int rear=s.length();
        int prev=s.length()-1;
        for(;prev>=0;prev--)
        {
            if(s[prev]==' ')
            {
                string m=s.substr(prev+1,rear-prev-1);
                if(m!=" " && !m.empty())
                    result.push_back(m);
                rear=prev;
            }
            else if(prev==0 &&s.substr(prev,rear-prev)!=" ")
                result.push_back(s.substr(prev,rear-prev));
        }
        
        int len=result.size();
        string res;
        for(int i=0;i<len;i++)
        {
            res+=result[i]+" ";
        }
        s=res.substr(0,res.length()-1);
        return;
    }
};