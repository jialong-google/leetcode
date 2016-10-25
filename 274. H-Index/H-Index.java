public class Solution {
    // the value of h index will never exceed the length of citations.
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0)
            return 0;
        int[] bin = new int[citations.length + 1];
        for(int i =0 ;i < citations.length; i++)
        {
            if(citations[i] > citations.length)
            {
                bin[citations.length]++;
            }
            else
            {
                bin[citations[i]]++;
            }
        }
        
        for(int i = citations.length; i >= 0 ; i--)
        {
            if(bin[i] >= i)
            {
                return i;
            }
            bin[i - 1] += bin[i];
        }
        return 0;
    }
}