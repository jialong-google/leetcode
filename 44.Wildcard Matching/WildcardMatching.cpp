class Solution {
public:
    bool isMatch(string s, string p) {
        int si=0;
        int pi=0;
        int lens=s.length();
        int lenp=p.length();
        int record=-1;
        int start=-1;
        while(si<lens){//这个地方只需要控制主串。 
            if(s[si]==p[pi] || p[pi]=='?')
            {
                si++;
                pi++;
            }
            else if(p[pi]=='*')
            {
                record=si;
                start=pi;
                while(p[pi]=='*')
                    pi++;
            }
            else if(record==-1){//不匹配又没有*，扯什么犊子= =
                return false;
            }
            else{//不匹配 且有*
                record++;
                si=record;
                pi=start+1;
            }
        }
        if(si==lens){
            while(p[pi]=='*')
                pi++;
            if(pi==lenp)
                return true;
            else 
                return false;
        }
        //pi >=lenp
    /*   当主串不为空而子串为空的时候，会被拉回去继续匹配，所以不必要单独拎出来。*/
        return true;//default: true.
    }
};