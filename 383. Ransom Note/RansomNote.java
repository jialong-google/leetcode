public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int mask = 0;
        int[] letter = new int[26];
        for(int i = 0; i < ransomNote.length(); i++)
        {
            int loci = ransomNote.charAt(i) - 'a';
            letter[loci] ++;
            mask |= 1 << loci;
        }
        for(int i = 0; i < magazine.length(); i++)
        {
            int loci = magazine.charAt(i) - 'a';
            letter[loci] -- ;
            if(letter[loci] <= 0)
            {
                mask &= ~(1 << loci);
            }
        }
        return mask == 0;
    }
}