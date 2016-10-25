public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 )
            return nums1;
        if(nums2 == null || nums2.length == 0)
            return nums2;
        ArrayList<Integer> intersect = new ArrayList<Integer>();
        Set<Integer> hash = new HashSet<Integer>();
        if(nums2.length < nums1.length)
        {
            int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
        }
        for(int i = 0; i < nums1.length; i++)
        {
            hash.add(nums1[i]);
        }
        for(int j = 0; j < nums2.length; j++)
        {
            if(hash.contains(nums2[j]) == true)
            {
                intersect.add(nums2[j]);
                hash.remove(nums2[j]);
            }
        }
        int[] res = new int[intersect.size()];
        for(int i = 0; i < res.length; i++)
        {
            res[i] = intersect.get(i);
        }
        return res;
    }
}