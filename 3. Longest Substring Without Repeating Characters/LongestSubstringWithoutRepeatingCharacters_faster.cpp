class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        if(s.empty())
            return 0;
        bool p[256]={false};
        int len=s.length();
        int ml=0;
        int l=0;
        int r=0;
        while(r!=len){
            if(!p[s[r]]){
                p[s[r]]=true;
                r++;
            }
            else//结算
            {
                ml=max(r-l,ml);
                while(p[s[r]]==true)
                {
                    p[s[l]]=false;
                    l++;
                }
            }
        }
        return max(ml,r-l);
    }
};