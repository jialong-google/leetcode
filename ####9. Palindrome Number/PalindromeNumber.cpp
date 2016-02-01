class Solution {
public:
    bool isPalindrome(int x) {
        if(x<0)
            return false;
        int origin=x;
        int len=0;
        long long int p=1;
        while(origin!=0)
        {
            p=p*10;
            len++;
            origin=origin/10;
        }
        p=p/10;
        origin=x;
        for(int i=0;i<len/2;i++){
            if((origin/p) != (origin%10))
            {
                return false;
            }
            origin=origin%p;
            p=p/100;
            origin=origin/10;
        }
        return true;
    }
};