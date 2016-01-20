class Solution {
public:
    void reverseWords(string &s) {
        if(s.empty())
            return;
        reverse(s.begin(),s.end());
        string::iterator prev=s.begin();
        for(string::iterator it= s.begin(); it!=s.end();it++){
            if(*it==' ')
            {
                reverse(prev,it);//please pay attention here! should be it instead of it+1; reverse [first, second-1];
                prev=it+1;
            }
        }
        reverse(prev,s.end());
    }
};