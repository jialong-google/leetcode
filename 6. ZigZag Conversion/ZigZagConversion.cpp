class Solution {
public:
    string convert(string s, int numRows) {
        string res;
        int len=s.length();
        if(numRows==1)
            return s;
        for(int i=0;i<numRows;i++)
        {
            for(int j=0;i+j<len;j+=2*(numRows-1))
            {
                res+=s[i+j];
                if(i==0 || i==numRows-1)
                    continue;
                if(i+j+2*(numRows-i-1)<len)
                    res+=s[i+j+2*(numRows-i-1)];
            }
        }
        return res;
    }
};