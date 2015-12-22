class Solution {
public:
    string shortestPalindrome(string s) {
        string r=s;
        reverse(r.begin(),r.end());
        int j=s.length();
        int i=0;
        for(;j>=0;i++,j--){
            if(s.substr(0,j)==r.substr(i)){
                string tmp= s.substr(j);
                reverse(tmp.begin(),tmp.end());
                return tmp+s;
            }
        }
    }
};