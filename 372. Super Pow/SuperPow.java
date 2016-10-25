public class Solution {
    
    /*
    public int superPow(int a, int[] b) {
    int result=1;
 
    for(int i=0; i<b.length; i++){
        result = (helper(result, 10)*helper(a, b[i]))%1337; // result^10 
    }
 
    return result;
}
 
public int helper(int x, int n){
    if(n==0)
        return 1;
    if(n==1)
        return x%1337;
 
    return helper(x%1337, n/2)*helper(x%1337,n-n/2)%1337;    
}*/
    public int superPow(int a, int[] b) {
        int res = 1;
        for(int i = 0; i < b.length; i++)
        {
            res = (helper(res, 10) * helper(a, b[i]) )% 1337;// important!
        }
        return res;
    }
    public int helper(int a, int b){
        if(b == 0)
            return 1;
        if(b == 1) 
            return a % 1337;
        int half = helper(a%1337, b/2);
        if(b % 2 == 0)
            return half * half % 1337;
        else
            return ((half * half % 1337 )* (a% 1337))%1337;
        
        //return helper(a % 1337, b /2 )* helper(a % 1337, b -b / 2) % 1337;
    }
    
    
}