class Solution {
public:

    void rotatestring(string &s,int first,int second)
    {
        char temp;
        while(first!=second && second+1!=first)//pay special attention here!!!
        {
            temp=s[first];
            s[first]=s[second];
            s[second]=temp;
            first++;
            second--;
        }
    }
    void reverseWords(string &s) {
        if(s.empty())
            return;
        int len=s.length();
        rotatestring(s,0,len-1);
        
        int prev=0;
        for(int i=0;i<len;i++)
        {
            if(s[i]==' '){
                rotatestring(s,prev,i-1);
                prev=i+1;
            }
        }
        rotatestring(s,prev,len-1);
    }
};