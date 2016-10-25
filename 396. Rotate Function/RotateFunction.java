public class Solution {
    public int maxRotateFunction(int[] A) {
        if(A == null || A.length <= 1)
            return 0;
        int sum = 0;
        int F1 = 0;
        for(int i = 0; i < A.length ; i++)
        {
            sum += A[i];
            F1 += i * A[i];
        }
        int sol = F1;
        for(int i = 1; i < A.length; i++)
        {
            F1 = F1 + sum - A.length * A[A.length -i];
            sol = Math.max(F1, sol);
        }
        return sol;
    }
}