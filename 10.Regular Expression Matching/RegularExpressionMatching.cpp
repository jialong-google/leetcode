class Solution {
public:
    bool isMatch(string s, string p) {
        int x=s.length()+1;
        int y=p.length()+1;
        bool re[x][y];
        for(int i=0;i<x;i++)
            for(int j=0;j<y;j++)
                re[i][j]=false;
        re[0][0]=true;
        for(int j=1;j<y;j++)
        for(int i=0;i<x;i++)
            
                if(p[j-1] =='*')//match *
                {
                    if(i>0 &&j>=2 && (p[j-2] == s[i-1] || p[j-2] == '.' ) && re[i-1][j])//match more.????
                        re[i][j]=true;
                    else if(j>=2 && re[i][j-2])
                        re[i][j]=true;//match one
                    else if(j>=1 && re[i][j-1])
                        re[i][j]=true;
                }
                else if(p[j-1] == '.' && i>=1)//match .//ok
                {
                    re[i][j]=re[i-1][j-1];
                }
                else if(i>=1)//match char//ok
                {
                    re[i][j]=re[i-1][j-1] && (s[i-1] == p[j-1]);
                }
        return re[x-1][y-1];
    }
};