class Solution {
public:
    int reverse(int x) {
          long long int newN =0, left =0;
          while(x != 0)
          {  
                 left = x%10;  
                 newN = newN*10 + left;  
                 x = x/10;  
          }  
        if((long long int)((int)newN)==newN)
            return newN;
        else
            return 0;
    }
};