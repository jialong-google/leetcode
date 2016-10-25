public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if(C < E || D < F || G < A || H < B)
        {
            return (D - B)*(C - A) + (H - F)*(G - E);
        }
        return (D - B)*(C - A) + (H - F)*(G - E) - (Math.min(H, D) - Math.max(F, B)) *(Math.min(C, G) - Math.max(A,E));
        
    }
}