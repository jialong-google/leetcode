class Solution {
public:
    bool isAnagram(string s, string t) {
        vector<char> s1;
        vector<char> t1;
        int lens=s.length();
        int lent=t.length();
        if(lens!=lent)
            return false;
        for(int i=0;i<lens;i++)
        {
            s1.push_back(s[i]);
        }
        for(int i=0;i<lent;i++)
        {
            t1.push_back(t[i]);
        }
        sort(s1.begin(),s1.end());
        sort(t1.begin(),t1.end());
        for(int i=0;i<lens;i++)
            if(s1[i]!=t1[i])
                return false;
        return true;
    }
};