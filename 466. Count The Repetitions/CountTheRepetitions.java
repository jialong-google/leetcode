public class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int count = 0; 
        int j = 0;
        //List<Integer> nextIndex = new ArrayList<Integer>(n1 + 1);
        //List<Integer> countMap = new ArrayList<Integer>(n1 + 1);
        int[] nextIndex = new int[n1 + 1];
        int[] countMap = new int[n1 + 1];
        for(int k = 1; k <= n1; k++)
        {
            for(int i = 0; i < s1.length(); i++)
            {
                if(s2.charAt(j) == s1.charAt(i))
                {
                    j++;
                    if(j == s2.length())
                    {
                        count++;
                        j = 0;
                    }
                }
            }
            //nextIndex.insert(k, j);
            nextIndex[k] = j;
            //countMap.insert(k, count);
            countMap[k] = count;
            for(int i = 1; i < k; i++)
            {
                if(nextIndex[i] == j)
                {
                    int prefix = countMap[i];
                    int repeat = (countMap[k] - countMap[i]) * (n1 - i) / (k - i);
                    int suffix = countMap[i + (n1 - i) % (k - i)] - countMap[i];
                    return (prefix + repeat + suffix) / n2;
                }
            }
        }
        return countMap[n1] / n2;
    }
}