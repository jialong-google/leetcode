public class Solution {
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        if((org != null && org.length != 0) && (seqs == null|| seqs.length == 0))
            return false;
        Map<Integer, Set<Integer>> hash = new HashMap<Integer, Set<Integer>>();
        for(int[] seq : seqs)
        {
            for(int i = 0; i < seq.length; i++)
            {
                if(seq[i] <= 0 || seq[i] > org.length)
                    return false;
                if(i == seq.length - 1)
                    break;
                Set<Integer> temp = hash.get(seq[i]);
                if(temp == null)
                {
                    temp = new HashSet<Integer>();
                }
                temp.add(seq[i + 1]);
                hash.put(seq[i], temp);
            }
        }
        for(int i = 0; i < org.length ; i++)
        {
            if(i!= org.length - 1)
            {
                Set<Integer> temp = hash.get(org[i]);
                if(temp == null || !temp.contains(org[i + 1]))
                    return false;
            }
        }
        if(org.length == 0 || hash.get(org[org.length - 1]) == null)
            return true;
        return false;
        
    }
}