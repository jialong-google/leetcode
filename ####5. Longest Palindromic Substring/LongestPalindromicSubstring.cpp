class Solution {
public:

    string preprocess(string s)
    {
        int n = s.length();
        string ret;
        for (int i = 0; i < n; i++)
            ret += "#" + s.substr(i, 1);
        ret += "#";
        return ret;
    }
    string longestPalindrome(string s) {
        if(s.empty())
            return "";
        string s1=preprocess(s);
        int len=s1.length();
        int P[len];
        P[0]=0;
        int center=0;
        int greedy=0;
        for(int i=1;i<len;i++)
        {
            if(i>=center+P[center])
            {
                int level=0;
                center=i;
                while(s1[i+level]==s1[i-level] && i-level>=0 && i+level<len)
                    level++;
                P[i]=level-1;
            }
            else if(center-i-P[2*center-i]<=-P[center]){
                int level=center-i+P[center]+1;
                center=i;
                while(s1[i+level]==s1[i-level] && i-level>=0 && i+level<len)
                    level++;
                P[i]=level-1;
            }
            else
                P[i]=P[2*center-i];
            if(P[i]>P[greedy])
                greedy=i;
        }
        return s.substr((greedy-P[greedy])/2,P[greedy]);
    }
};