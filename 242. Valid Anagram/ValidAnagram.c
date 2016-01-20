class Solution {
public:
    bool isAnagram(string s, string t) {
        unordered_map<char,int> m;
        int len=s.length();
        for(int i=0;i<len;i++)
        {
            if(m.find(s[i])==m.end())
                m[s[i]]=1;
            else
                m[s[i]]++;
        }
        if(t.length()!=len)
            return false;
        for(int i=0;i<len;i++)
        {
            if(m[t[i]]>0)
                m[t[i]]--;
            else
                return false;
        }
        return true;
    }
};