public class Solution {
    public int compareVersion(String version1, String version2) {
        if(version1 == null || version1.length() == 0)
        {
            return -1;
        }
        if(version2 == null || version2.length() == 0)
        {
            return 1;
        }
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for(int i = 0; i < v1.length && i < v2.length; i++)
        {
            int cur1 = Integer.parseInt(v1[i]);
            int cur2 = Integer.parseInt(v2[i]);
            if(cur2 < cur1)
            {
                return 1;
            }
            if(cur2 > cur1)
            {
                return -1;
            }
        }
        if(v2.length >= v1.length)
        {
            for(int i = v1.length; i < v2.length; i++)
            {
                if(Integer.parseInt(v2[i])!= 0)
                {
                    return -1;
                }
            }
            return 0;
        }
        else// v2.length < v1.length
        {
            for(int i = v2.length; i < v1.length; i++)
            {
                if(Integer.parseInt(v1[i])!= 0)
                {
                    return 1;
                }
            }
            return 0;
        }
    }
}