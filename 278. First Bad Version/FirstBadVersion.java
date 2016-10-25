/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int begin = 1;
        int end = n;
        int medium = 0;
        while(begin < end - 1)
        {
            medium = begin + (end - begin) /2;
            if(isBadVersion(medium))
            {
                end = medium;
            }
            else
            {
                begin = medium + 1;
            }
        }
        if(isBadVersion(begin))
            return begin;
        return end;
    }
}