class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        if(s.empty())
            return 0;
        unordered_map<char, int> p;
        int len=s.length();
        int ml=0;
        int l=0;
        int r=0;
        while(r!=len){
            if(p.find(s[r])== p.end()){
                p[s[r]]=r;
                r++;
            }
            else//结算
            {
                ml=max(r-l,ml);
                while(p.find(s[r]) != p.end())
                {
                    //delete s[l] l++
                    p.erase(s[l]);
                    l++;
                }
            }
        }
        return max(ml,r-l);
    }
};